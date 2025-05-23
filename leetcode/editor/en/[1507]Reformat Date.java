//Given a date string in the form Day Month Year, where: 
//
// 
// Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}. 
// Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", 
//"Sep", "Oct", "Nov", "Dec"}. 
// Year is in the range [1900, 2100]. 
// 
//
// Convert the date string to the format YYYY-MM-DD, where: 
//
// 
// YYYY denotes the 4 digit year. 
// MM denotes the 2 digit month. 
// DD denotes the 2 digit day. 
// 
//
// 
// Example 1: 
//
// 
//Input: date = "20th Oct 2052"
//Output: "2052-10-20"
// 
//
// Example 2: 
//
// 
//Input: date = "6th Jun 1933"
//Output: "1933-06-06"
// 
//
// Example 3: 
//
// 
//Input: date = "26th May 1960"
//Output: "1960-05-26"
// 
//
// 
// Constraints: 
//
// 
// The given dates are guaranteed to be valid, so no error handling is 
//necessary. 
// 
//
// Related Topics String 👍 492 👎 439


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reformatDate(String date) {
        String[] dateArr = date.split(" ");
        String day = dateArr[0].substring(0, dateArr[0].length() - 2);
        if (day.length() == 1) day = "0" + day;
        String month = "0";
        switch (dateArr[1]) {
            case "Jan":
                month = "01";
                break;
            case "Feb":
                month = "02";
                break;
            case "Mar":
                month = "03";
                break;
            case "Apr":
                month = "04";
                break;
            case "May":
                month = "05";
                break;
            case "Jun":
                month = "06";
                break;
            case "Jul":
                month = "07";
                break;
            case "Aug":
                month = "08";
                break;
            case "Sep":
                month = "09";
                break;
            case "Oct":
                month = "10";
                break;
            case "Nov":
                month = "11";
                break;
            case "Dec":
                month = "12";
                break;
        }
        return dateArr[2] + "-" + month + "-" + day;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
