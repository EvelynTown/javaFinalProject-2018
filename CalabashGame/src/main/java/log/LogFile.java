package log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import constants.Constants;
import formation.Formation;

/**
 * 
 * 文件记录类
 * 
 * @author TangSiyi
 *
 */

public class LogFile implements Constants {
	String formation;
	List<Log> logs = new ArrayList<>();
	String result;

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public Formation getFormation() {
		switch (formation) {
		case "CRANE":
			return Formation.CRANE;
		case "GOOSE":
			return Formation.GOOSE;
		case "YOKE":
			return Formation.YOKE;
		case "SNAKE":
			return Formation.SNAKE;
		case "FISH":
			return Formation.FISH;
		case "SQUARE":
			return Formation.SQUARE;
		case "MOON":
			return Formation.MOON;
		case "FRONT":
			return Formation.FRONT;
		default:
			return null;
		}
	}

	public void add(Log log) {
		logs.add(log);
	}

	public void saveFile() {
		try {
			String path = "Logs/log.txt";
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(this.formation + "\r\n");
			fileWriter.flush();
			fileWriter.write(this.result + "\r\n");
			fileWriter.flush();
			for (Log log : logs) {
				fileWriter.write(log.toString() + "\r\n");
				fileWriter.flush();
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("error when read file");
			e.printStackTrace();
		}
	}

	public void readFile(File file) {
		try {
			if (file.isFile() && file.exists()) {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(reader);
				String line = null;
				if ((line = bufferedReader.readLine()) != null)
					formation = line;
				if ((line = bufferedReader.readLine()) != null)
					result = line;
				while ((line = bufferedReader.readLine()) != null) {
					String[] split = line.split(" ");
					if (split[0].equals("move")) {
						int id = Integer.parseInt(split[1]);
						int x = Integer.parseInt(split[2]);
						int y = Integer.parseInt(split[3]);
						MoveLog moveLog = new MoveLog(id, x, y);
						logs.add(moveLog);
					} else if (split[0].equals("fight")) {
						int id = Integer.parseInt(split[1]);
						int x = Integer.parseInt(split[2]);
						int y = Integer.parseInt(split[3]);
						int opponent = Integer.parseInt(split[4]);
						int op_x = Integer.parseInt(split[5]);
						int op_y = Integer.parseInt(split[6]);
						boolean re = LOSE;
						if (split[7].equals("win"))
							re = WIN;
						FightLog fightLog = new FightLog(id, x, y, opponent, op_x, op_y, re);
						logs.add(fightLog);
					} else
						System.out.println("something went wrong when read file");
				}
				bufferedReader.close();
				reader.close();
				printFile();
			} else
				System.out.println("cannot open file");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("error when read file");
			e.printStackTrace();
		}
	}

	private void printFile() {
		for (Log log : logs)
			System.out.println(log.toString());
	}

	// 得到队首的log
	public Log getLog() {
		if (logs.isEmpty())
			return null;
		else
			return logs.get(0);
	}

	public void delLog() {
		if (!logs.isEmpty())
			logs.remove(0);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
