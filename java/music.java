package mdbase;
import java.sql.*;

/**
* <h1>Music Titles and Rewards Database</h1>
*
* @author  Blane Staskiewicz
*/
public class music{ 
	// database URL    
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/music";
	
	/** 
	* This method is the main/driver method
	*
	* @param args  Unused
	*/
	public static void main(String[] args) {
		Connection connection = null;      
		Statement statement = null;      
		ResultSet resultSet = null;
		     
		try {    
			connection = DriverManager.getConnection(DATABASE_URL, "username", "password");
			
			// create tables
			PreparedStatement create = connection.prepareStatement("CREATE TABLE IF NOT EXISTS musicTitles("
					+ "musicID INT NOT NULL, "
					+ "genre varchar (20) NOT NULL,"
					+ "artist varchar (30) NOT NULL,"
					+ "title varchar (20) NOT NULL,"
					+ "album varchar (30) NOT NULL,"
					+ "releaseDate INT NOT NULL,"
					+ "PRIMARY KEY (musicID) )");
			create.executeUpdate();
			create = connection.prepareStatement("CREATE TABLE IF NOT EXISTS musicAwards("
					+ "musicID INT NOT NULL, "
					+ "award varchar (30) NOT NULL,"
					+ "awardYear INT NOT NULL,"
					+ "FOREIGN KEY (musicID) REFERENCES musicTitles(musicID))");
			create.executeUpdate();
			
			// populating musicTitles
			PreparedStatement posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+8+"', 'Pop', 'Adele', 'Hello', '25', '"+2015+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+9+"', 'Classical', 'Andrea Bocelli', 'Because We Believe', 'Amore', '"+2006+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+4+"', 'Jazz', 'Branford Marsalis', 'N/A', 'I Heard You Twice the First Time', '"+1992+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+7+"', 'Pop', 'Elton John', 'Candle in the Wind 1997', 'Something About the Way You Look Tonight', '"+1997+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+10+"', 'Easy Listening', 'James Galway', 'The Dawning Of The Day', 'Wings of Song', '"+2004+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+1+"', 'Rock', 'Led Zeppelin', 'N/A', 'Celebration Day', '"+2012+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+2+"', 'Rock', 'Pink Floyd', 'Marooned', 'The Division Bell', '"+1994+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+3+"', 'Jazz', 'Spyro Gyra', 'Best Friends', 'Road Scholars', '"+1998+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+6+"', 'Classical Crossover', 'Yo-Yo Ma', 'Gabriel's Oboe', 'Yo-Yo Ma Plays Ennio Morricone', '"+2004+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicTitles(musicID, genre, artist, title, album, releaseDate)"
					+ "VALUES ('"+5+"', 'Classical Crossover', 'Yo-Yo Ma', 'N/A', 'Yo-Yo Ma & Friends: Songs Of Joy And Peace', '"+2008+"')");
			posted.executeUpdate();
			
			// populating musicTitles
			posted = connection.prepareStatement("INSERT INTO musicAwards(musicID, award, awardYear)"
					+ "VALUES ('"+8+"', 'Song of the Year', '"+2016+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicAwards(musicID, award, awardYear)"
					+ "VALUES ('"+1+"', 'Best Rock Album', '"+2013+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicAwards(musicID, award, awardYear)"
					+ "VALUES ('"+5+"', 'Best Classical Crossover Album', '"+2009+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicAwards(musicID, award, awardYear)"
					+ "VALUES ('"+7+"', 'Best Male Pop Vocal Performance', '"+1997+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicAwards(musicID, award, awardYear)"
					+ "VALUES ('"+2+"', 'Best Rock Instrumental Performance', '"+1994+"')");
			posted.executeUpdate();
			posted = connection.prepareStatement("INSERT INTO musicAwards(musicID, award, awardYear)"
					+ "VALUES ('"+4+"', 'Best Jazz Instrumental Performance', '"+1992+"')");
			posted.executeUpdate();
			
			// making query statement, resultSet, metaData, numberOfColumns
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT musicID, genre, artist, title, album, releaseDate FROM musicTitles ORDER BY artist");
			ResultSetMetaData metaData = resultSet.getMetaData();            
			int numberOfColumns = metaData.getColumnCount();  
			
			// printing musicTitle column names
			System.out.println("\"musicTitles\" Table Of Music Database:\n"); 
			for(int i = 1; i <= numberOfColumns; i++){  
				System.out.printf("%-8s\t", metaData.getColumnName(i));    
			}
            for(int i = 1; i <= numberOfColumns; i++){      
            	System.out.printf("%-8s\t", "---------");            
            }            
            System.out.println();
            
            // printing musicTitle resultSet
            while(resultSet.next()){                
            	for(int i = 1; i <= numberOfColumns; i++){                    
            		System.out.printf("%-8s\t", resultSet.getObject(i));
            	}                
            	System.out.println();            
            }
            resultSet.close();
            statement.close();
            
            // making query statement, resultSet, metaData, numberOfColumns
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT genre, artist, award, awardYear FROM musicAwards ORDER BY awardYear DESC");
			metaData = resultSet.getMetaData();            
			numberOfColumns = metaData.getColumnCount();  
			
			//printing musicAwards column names
			System.out.println("\"musicAwards\" Table Of Music Database:\n"); 
			for(int i = 1; i <= numberOfColumns; i++){                
				System.out.printf("%-8s\t", metaData.getColumnName(i));            
			}
            for(int i = 1; i <= numberOfColumns; i++){                
            	System.out.printf("%-8s\t", "---------");            
            }            
            System.out.println();
            
            // printing musicAwards resultSet
            while(resultSet.next()){                
            	for(int i = 1; i <= numberOfColumns; i++){                    
            		System.out.printf("%-8s\t", resultSet.getObject(i));
            	}                
            	System.out.println();            
            }
            resultSet.close();
            statement.close();
            
            // querying of musicTitle and musicAwards tables for Artist Awards
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT genre, artist, award, awardYear FROM musicAwards "
					+ "INNER JOIN musicTitle ON musicAwards.musicID=musicTitle.musicID ORDER BY awardYear DESC");
			metaData = resultSet.getMetaData();            
			numberOfColumns = metaData.getColumnCount();  
			
			// printing musicAwards joined with musicTitle column names
			System.out.println("Musical Artists Who Have Received Awards:\n");
			for(int i = 1; i <= numberOfColumns; i++){                
				System.out.printf("%-8s\t", metaData.getColumnName(i));            
			}
            for(int i = 1; i <= numberOfColumns; i++){                
            	System.out.printf("%-8s\t", "---------");            
            }            
            System.out.println();
            
            // printing joined resultSet
            while(resultSet.next()){                
            	for(int i = 1; i <= numberOfColumns; i++){                    
            		System.out.printf("%-8s\t", resultSet.getObject(i));
            	}                
            	System.out.println();            
            }
            resultSet.close();
            statement.close();
            
            // making query statement, resultSet, metaData, numberOfColumns for Rock music
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT genre FROM musicTitle WHERE genre=\"Rock\" ORDER BY artist");
			metaData = resultSet.getMetaData();            
			numberOfColumns = metaData.getColumnCount();  
			
			// printing musicTitle column names
			System.out.println("Musical Listings Where The Genre Is \"Rock\":\n"); 
			for(int i = 1; i <= numberOfColumns; i++){                
				System.out.printf("%-8s\t", metaData.getColumnName(i));            
			}
            for(int i = 1; i <= numberOfColumns; i++){                
            	System.out.printf("%-8s\t", "---------");            
            }            
            System.out.println();
            
            // printing resultSet
            while(resultSet.next()){                
            	for(int i = 1; i <= numberOfColumns; i++){                    
            		System.out.printf("%-8s\t", resultSet.getObject(i));
            	}                
            	System.out.println();            
            } 
		}
		catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		finally {   
			// closing all
			try {                
				resultSet.close();                
				statement.close();                
				connection.close();            
			}                                                         
			catch (Exception exception) {                
				exception.printStackTrace();            
			}                                               
		}
	}
}
