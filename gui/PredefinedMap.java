package gui;
public class PredefinedMap {
	public static Space[][] createMap(int size){
		Space[][] map = new Space[16][16];
		int length = map.length-1;
		
		for(int i=0;i<length;i++){
			map[i][0] = new Block(i*size, 0, true, true, size);
			map[0][(length-i)] = new Block(0, (length-i)*size, true, true, size);
			map[(length-i)][length] = new Block((length-i)*size, length*size, true, true, size);
			map[length][i] = new Block(length*size, i*size, true, true, size);
		}
		for(int y=1;y<length;y++)
			for(int x=1;x<length;x++)
				map[x][y] = new Floor(x*size, y*size, size);
		for(int m=2;m<map.length/2;m+=2){
			length -=2;
			for(int i=m;i<length;i++){
				if(i%5!=0){
					map[i][m] = new Block(i*size, m*size, true, true, size);
					map[m][(length-i+m)] = new Block(m*size, (length-i+m)*size, true, true, size);
					map[(length-i+m)][length] = new Block((length-i+m)*size, length*size, true, true, size);
					map[length][i] = new Block(length*size, i*size, true, true, size);
				}
			}
		}
		return map;
	}
	public static Space[][] createTextbasedMap(int size){
		
		Space[][] map = new Space[18][20];
		char[][] textMap = new char[18][20],wrongTextMap = new char[][]{
				{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',},
				{'X','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','X',},
				{'X','O','X','X','O','X','X','O','X','X','O','X','X','O','X','X','O','X',},
				{'X','O','X','X','O','X','X','O','O','O','O','X','X','O','X','X','O','X',},
				{'X','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','X',},
				{'X','O','X','X','O','X','X','O','X','X','O','X','X','O','X','X','O','X',},
				{'X','O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','X',},
				{'X','X','X','X','O','X','O','X','X','X','X','O','X','O','X','X','X','X',},
				{'X','X','X','X','O','X','O','X','O','O','X','O','X','O','X','X','X','X',},
				{'X','X','X','X','O','O','O','X','O','O','X','O','O','O','X','X','X','X',},
				{'X','X','X','X','O','X','O','O','O','O','O','O','X','O','X','X','X','X',},
				{'X','O','O','O','O','X','O','X','X','X','X','O','X','O','O','O','O','X',},
				{'X','O','X','X','O','X','O','O','O','O','O','O','X','O','X','X','O','X',},
				{'X','O','X','X','O','O','O','X','X','X','X','O','O','O','X','X','O','X',},
				{'X','O','O','X','X','X','O','O','O','O','O','O','X','X','X','O','O','X',},
				{'X','X','O','X','O','O','O','X','X','X','X','O','O','O','X','O','X','X',},
				{'X','O','O','O','O','X','O','O','X','X','O','O','X','O','O','O','O','X',},
				{'X','O','X','X','X','X','X','O','X','X','O','X','X','X','X','X','O','X',},
				{'X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X',},
				{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',},
		};
		textMap = invertCharArray(wrongTextMap);
		for(int x=0;x<map.length;x++)
			for(int y=0;y<map[0].length;y++){
				if(textMap[x][y]=='O')
					map[x][y] = new Floor(x*size, y*size, size);
				else if(textMap[x][y]=='X')
					map[x][y] = new Block(x*size, y*size, true, true, size);
			}
				
		return map;
	}
	public static char[][] invertCharArray(char[][] array){
		char[][] newArray = new char[array[0].length][array.length];
		for(int x=0;x<array[0].length;x++)
			for(int y=0;y<array.length;y++)
				newArray[x][y] = array[y][x];
		return newArray;
	}
	
}
