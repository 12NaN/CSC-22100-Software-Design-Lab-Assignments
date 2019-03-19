import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConvert{
	private ArrayList<MorseCode> listCodes = new ArrayList<>();
	
	public MorseCodeConvert(String fileName) throws Exception{
		try(Scanner file = new Scanner(new File(fileName))){
			try{
				while(file.hasNext()){
					String strln = file.nextLine();
					if(strln.length() > 0){
						String [] line = strln.split("\t");
						if(line.length == 2 && line[0].length() == 1){
							try{
								listCodes.add(new MorseCode(line[0].charAt(0), line[1]));
							}
							catch(Exception e){
								System.err.println(e.toString());
							}
						}
						else
						{
							System.err.println("Skipping line: " + strln);
						}
					}
				}
			}
			finally{
				file.close();
			}
		}
		catch(FileNotFoundException e){
			throw new Exception("Invalid file name: " + fileName);
		}
	}
	
	public void printMorseCodeList(){
		for(MorseCode i : listCodes){
			System.out.println("('"+ i.getCh() + "', " + i.getCode() + ")");
		}
	}
	
	public void convertString(String str){
		if(str != null && str.length() > 0){
			char [] chStr = str.toUpperCase().toCharArray();
			String mc;
			for(int i = 0; i < chStr.length; i++){
				char ch = chStr[i];
				if(ch != ' '){
					mc = null;
					for(MorseCode j : listCodes){
						if(j.getCh() == ch){
							mc = j.getCode();
							break;
						}
					}
					if(mc == null){
						System.out.print("?");
					}
					else{
						System.out.print(mc);
					}
					System.out.print(" ");
				  }
			  }
		  }
		  System.out.println();
	}
	
	public void convertFile(String fileStr) throws Exception{
	    try(Scanner file = new Scanner(new File(fileStr))){
	        try {
	        	while(file.hasNext()) {
	        		this.convertString(file.nextLine());
	            }
	        } finally {
	        	file.close();
	        }     
	    } 
	    catch (FileNotFoundException e) {
	    	throw new Exception("Invalid file name: " + fileStr);
		}		
	}
}