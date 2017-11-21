
// CS Dojo helped me with a lot of this code//
import java.util.*;
import java.io.*;

public class WordSearch{
    private char[][]data;
    private Random randg;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private int seedd;
    private char[][] solution;

    
    public WordSearch(int rows,int cols,String filename){
	this(rows, cols, filename, new Random().nextInt());
    }


   public WordSearch(int rows,int cols,String filename, int seed){
 	data = new char[rows][cols];
	randg = new Random((long)seed);
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	seedd = seed;
	solution = new char[rows][cols];
	clear();
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		wordsToAdd.add(in.next());
	    }
	} catch (FileNotFoundException e){
    	    System.out.println("File not found: " + filename);
	}
	addAllWords(filename);
	for (int x = 0; x <data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		solution[x][y] = data[x][y];
	    }
	}

    }

    public int getSeed(){
	return seedd;
    }

    public String getSolution(){
	String ans = "";
	for (int i = 0; i < data.length; i++){
	    for (int x = 0; x < data[i].length; x++){
		ans += solution[i][x] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }


    private void clear(){
	for (int i = 0; i < data.length; i++){
	    for (int x = 0; x < data[i].length; x++){
		data[i][x] = '_';
	    }
	}
    }


    public String toString(){
	String ans = "";
	for (int i = 0; i < data.length; i++){
	    for (int x = 0; x < data[i].length; x++){
		ans += data[i][x] + " ";
	    }
	    ans += "\n";
	}
	ans += "Words To Find: " + (wordsAdded.toString()).substring(1,(wordsAdded.toString()).length() - 1);
	ans += "\nSeed: " + getSeed();
	return ans;
    }


    public boolean addWordHorizontal(String word,int row, int col){
	try{
	    for (int i = 0; i < word.length(); i++){
		if ((data[row][col + i] != word.charAt(i)) && (data[row][col + i] != '_')){
		    return false;
		}
	    }
	    for (int i = 0; i < word.length(); i++){
		data[row][col + i] = word.charAt(i);
	    }
	    return true;
	} catch (IndexOutOfBoundsException a){
	return false;
	}
    }


    public boolean addWordVertical(String word,int row, int col){
	try{
	    for (int i = 0; i < word.length(); i++){
		if ((data[row + i][col] != word.charAt(i)) && (data[row + i][col] != '_')){
		    return false;
		}
	    }
	    for (int i = 0; i < word.length(); i++){
		data[row + i][col] = word.charAt(i);
	    }
	    return true;
	} catch(IndexOutOfBoundsException a){
	return false;
	}
    }


    public boolean addWordDiagonal(String word,int row, int col){
	try{
	    for (int i = 0; i < word.length(); i++){
		if ((data[row + i][col + i] != word.charAt(i)) && (data[row + i][col + i] != '_')){
		    return false;
		}
	    }
	    for (int i = 0; i < word.length(); i++){
		data[row + i][col + i] = word.charAt(i);
	    }
	    return true;
	} catch(IndexOutOfBoundsException a){
	    return false;
	}
    }

    private boolean addWord(int row, int col, String word,  int xcor, int ycor){
	word = word.toUpperCase();
	if (xcor == 0 && ycor == 0){
	    return false;
	}
        try{
	    for (int i = 0; i < word.length(); i++){
		if ((data[row - i * ycor][col + i * xcor] != word.charAt(i)) && (data[row - i * ycor][col + i * xcor] != '_')){
		    return false;
		}
	    }
	    for (int i = 0; i < word.length(); i++){
		data[row - i * ycor][col + i * xcor] = word.charAt(i);
	    }
	    wordsAdded.add(word);
	    wordsToAdd.remove(word);
	    return true;
	} catch(ArrayIndexOutOfBoundsException a){
	    return false;
	
	}
    }

    public boolean randomize(){
	for (int i = 0; x < data.length; i++){
	    for (int x = 0; x < data[i].length; x++){
		if (data[i][x] == '_'){
		    int num = (int)(((Math.random() + 0.04) * 100) / 4 + 65);
		    data[i][x] = (char)(num);
		}
	    }
	}
	return true;
    }
   
        
    private boolean addAllWords(String filename){
	int len = wordsToAdd.size() * 900;
	for (int i = 0; i < len; i++){	
	    if (wordsToAdd.size() == 0){
		return true;
	    }
	    int x = randg.nextInt(3) - 1,
		y = randg.nextInt(3) - 1,
		num = randg.nextInt(wordsToAdd.size()),
		row = randg.nextInt(data.length),
		col = randg.nextInt(data[0].length);
	    String wor = wordsToAdd.get(num);
	    addWord(row, col, wor, x, y);
	    wordsToAdd.remove(wor);
	}
	return true;
    }
// This part was confusing and I couldn't figure it out w/o help//
    public static void main(String[] args){
	try {
	    int row = Integer.parseInt(args[0]),
		col = Integer.parseInt(args[1]);
	    if (row == 0 || col == 0 || !(args[2].substring(args[2].length() - 4).equals(".txt"))){
		throw new ArrayIndexOutOfBoundsException();
	    }
	    if (args.length > 3){
		int seed = Integer.parseInt(args[3]);
		WordSearch ws = new WordSearch(row, col, args[2], seed);
		if (args.length == 5 && args[4].equals("key")){
		    System.out.println(ws);
		}
		else{
		    ws.randomize();
		    System.out.println(ws);
		}
	    }
	    else{
		WordSearch ws = new WordSearch(row, col, args[2]);
		ws.randomize();
		System.out.println(ws);
	    }

	} catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("Please enter: \n java WordSearch <row> <col> <filename> <seed> <answers>");
	    System.out.println("<row>: the number of rows");
	    System.out.println("<col>: the number of columns");
    	    System.out.println("<filename>: the name of the file");
	    System.out.println("<seed>: the optional seed");
	    System.out.println("<answer>: the optional key to receive solution");
	}
    }

}
