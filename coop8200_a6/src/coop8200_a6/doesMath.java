package coop8200_a6;

/**
 * 
 * @author mason
 *
 * This class does all the math for the calculator.
 */
public class doesMath {
	
	/**
	 * 
	 * @param mathToDo- A string containing a simple math equestion ready to be computed.
	 * @return finaleResult- The final result of the computation of the given math equestion.
	 */
	@SuppressWarnings("finally")
	public static double theMath(String mathToDo){
		double finalResult = 0;
		try{
			if(mathToDo.contains("-")){
				String[] holder = mathToDo.split("-", 2);
				finalResult = (Double.parseDouble(holder[0])-Double.parseDouble(holder[1]));
			}
			else if(mathToDo.contains("+")){
				String[] holder = mathToDo.split("\\+", 2);
				finalResult = (Double.parseDouble(holder[0])+Double.parseDouble(holder[1]));
			}
			else if(mathToDo.contains("*")){
				String[] holder = mathToDo.split("\\*", 2);
				finalResult = (Double.parseDouble(holder[0])*Double.parseDouble(holder[1]));
			}
			else if(mathToDo.contains("/")){
				String[] holder = mathToDo.split("/", 2);
				finalResult = (Double.parseDouble(holder[0])/Double.parseDouble(holder[1]));
			}
		}finally{
			return finalResult;
		}
	}
}
