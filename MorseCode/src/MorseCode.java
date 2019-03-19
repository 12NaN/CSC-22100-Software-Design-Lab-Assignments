public class MorseCode{
	private char ch;
	private String code;
	
	public MorseCode(char ch, String code) throws Exception{
		if(ch >= 32 && ch <= 90){
			this.ch = ch;
			this.code = code;
		}
		else{
			throw new Exception("Out-of-range character: " + ch);
		}
	}
	
	public char getCh(){
		return ch;
	}
	
	public void setCh(char ch){
		this.ch = ch;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
}