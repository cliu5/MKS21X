import java.util.*;
import java.io.*;

public class WordSearch{
    private char[][]data;
    private Random randgen;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private int seed;
    private char[][] solution;

    
    public WordSearch(int rows,int cols,String filename){
	this(rows, cols, filename, new Random().nextInt());
    }


    public WordSearch(int rows,int cols,String filename, int seed){
 	data = new char[rows][cols];
	randgen = new Random((long)seed);
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
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
	for (int i = 0; i <data.length; i++){
	    for (int x = 0; x < data[i].length; x++){
		solution[i][x] = data[i][x];
	    }
	}

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
	for (int x = 0; x < data.length; x++){
	    for (int y = 0; y < data[x].length; y++){
		data[x][y] = '_';
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
	ans +=  (wordsAdded.toString()).substring(1,(wordsAdded.toString()).length() - 1);

	return ans;
    }


    // some of this gets confusing and people from other periods talked me through it//
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
    // this is basically horizontal + vertical combined//
   
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

    
    //this was confusing and I needed a lot of help//
    private boolean addWord(int row, int col, String word,  int xcor, int ycor){
	word = word.toUpperCase();
	if (xcor == 0 && ycor == 0){
	    return false;
	}
        try{
	    for (int x = 0; x < word.length(); x++){
		if ((data[row - x * ycor][col + x * xcor] != word.charAt(x)) && (data[row - x * ycor][col + x * xcor] != '_')){
		    return false;
		}
	    }
	    for (int x = 0; x < word.length(); x++){
		data[row - x * ycor][col + x * xcor] = word.charAt(x);
	    }
	    wordsAdded.add(word);
	    wordsToAdd.remove(word);
	    return true;
	} catch(ArrayIndexOutOfBoundsException a){
	    return false;
	
	}
    }

    // this was the worst and most confusing and I needed a lot of help//
    public boolean randomize(){
	for (int i = 0; i < data.length; i++){
	    for (int x = 0; x < data[i].length; x++){
		if (data[i][x] == '_'){
		    int num = (int)(((Math.random())  * 100) / 4 + 65);
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
	    int x = randgen.nextInt(3) - 1,
		y = randgen.nextInt(3) - 1,
		num = randgen.nextInt(wordsToAdd.size()),
		row = randgen.nextInt(data.length),
		col = randgen.nextInt(data[0].length);
	    String wor = wordsToAdd.get(num);
	    addWord(row, col, wor, x, y);
	    wordsToAdd.remove(wor);
	}
	return true;
    }
    //Parse is hard to get to work, dojo help//
    public static void main(String[] args){
	try {
	    int row = Integer.parseInt(args[0]),
		col = Integer.parseInt(args[1]);
	    if (row == 0 || col == 0){
		throw new ArrayIndexOutOfBoundsException();
	    }
	    if (args.length > 3){
		int seed = Integer.parseInt(args[3]);
		WordSearch hey = new WordSearch(row, col, args[2], seed);
		if (args.length == 5 && args[4].equals("key")){
		    System.out.println(hey);
		}
		else{
		    hey.randomize();
		    System.out.println(hey);
		}
	    }
	    else{
		WordSearch hey = new WordSearch(row, col, args[2]);
		hey.randomize();
		System.out.println(hey);
	    }
	   
	} catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("Please enter: rows, columns, filename, seed (optional), answer (optional)");
	}
    }

}
