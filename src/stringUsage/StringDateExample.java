/*
 * Program that accepts the date (date month year), separated by comma / space or both and print the date the format of YYYY-MM-DD
 *  Ex :21,May,2012 / 21 May 2012 / 21, May, 2012.
 */

package stringUsage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class StringDateExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//Scanner to accept date from user
		System.out.print("Enter date : ");
		String inputDate = scanner.nextLine();  //Reading date

		String[] dateCharArray = inputDate.split("[,\\s]+");  //Splitting date with space or comma into dateCharArray  array
		System.out.print("Date in format 'YYYY-MM-DD': ");
		for (int init = dateCharArray.length - 1; init >= 0; init--) { //iterating through  arrays
			if (dateCharArray[init].length() == 4) {//Condition for year to print, length will be 4 as yyyy
				System.out.print(dateCharArray[init] + "-");
				continue;
			}
			if (dateCharArray[init].length() > 2) {//Condition for month to print,Since month minimum length is 3, that is "May" 
				try {
					Date date = new SimpleDateFormat("MMM").parse(dateCharArray[init]);//Parses text from the beginning of the given string to produce a date
					Calendar cal = Calendar.getInstance();//Gets a calendar using the default time zone and locale
					cal.setTime(date);//Gets a calendar using the default time zone and locale
					int monthNumber = cal.get(Calendar.MONTH) + 1;// will return from 0 index so adding 1, so that month can start from 1
					String month = String.valueOf(monthNumber);
					if (monthNumber < 10) {// to print month in mm format 
						month = 0 + String.valueOf(monthNumber);// to make month as May =05
					}
					System.out.print(month + "-");

					continue;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (dateCharArray[init].length() == 2) {////Condition for year to print, length will be 2 as dd
				System.out.print(dateCharArray[init]);
				continue;

			}

		}

	}

}
