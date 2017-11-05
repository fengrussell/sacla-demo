package date

import java.text.SimpleDateFormat
import java.util.Date
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Demo {
    def main(args: Array[String]): Unit = {
//        val date=new SimpleDateFormat("yyyy-MM-dd H:mm:ss")
//        val dateFormated = date.format(line)
//        val dateFf=date.parse(dateFormated).getTime

//        val date = new Date()
//        val formater = new SimpleDateFormat("yyyy-MM-dd H:mm:ss")
//        val formater = new SimpleDateFormat("yyyyMMdd")
////        println(formater.format(date))
////        LocalDate.parse("20171022")
//        var dateFormater = DateTimeFormatter.ofPattern("yyyyMMdd");
//        val date = LocalDate.parse("20171022", dateFormater)
//
//        println(date.minusDays(1).format(dateFormater))

//        val date = "20171010"
//        new TimeFormat("yyyyMMdd").parse(date).inMilliseconds
//        val currentDay  = DateTime.parse(date)

        // 字符串转日期，用LocalDate，这个可以直接计算，减去多少天、加多少天
        val dateFormater = DateTimeFormatter.ofPattern("yyyyMMdd")
        val currentDay  = LocalDate.parse("20171021", dateFormater)
        val yesterday = currentDay.minusDays(1).format(dateFormater)
        val preWeek = currentDay.minusDays(7).format(dateFormater)
        val preMonth = currentDay.minusDays(30).format(dateFormater)

        println(yesterday)
        println(preWeek)
        println(preMonth)
    }
}
