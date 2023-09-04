package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class LeaderBoardModel extends AbstractTableModel{
	
	
	private static final String[] LEADERBOARD_HEADERS = new String[]{"Rank","Username","Score"};
	private final List<User> userList;
	
	
	public LeaderBoardModel(List<User> userList) {
		List<User> userListCopy = new ArrayList<User>(userList);
		userListCopy.sort((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore()));
		this.userList = userListCopy;
	}

	@Override
	public int getRowCount() {
		return userList.size();
	}

	@Override
	public int getColumnCount() {
		return LEADERBOARD_HEADERS.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(columnIndex == 0) {
			return rowIndex+1;
		}
		if(columnIndex == 1) {
			return userList.get(rowIndex).getUserName();
		}
		if(columnIndex == 2) {
			return userList.get(rowIndex).getScore();
		}
		
		return null;
		
		
	}

	@Override
	public String getColumnName(int column) {
		return LEADERBOARD_HEADERS[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	
	

}
