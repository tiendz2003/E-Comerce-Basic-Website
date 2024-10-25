package Array

import java.util.Scanner
import kotlin.collections.ArrayList

fun main() {
    val scanner = Scanner(System.`in`)
    val array = ArrayList<Int>()
    println("Nhập số lượng phần tử ban đầu:")
    val initialSize = scanner.nextInt()

    for (i in 0 until initialSize) {
        array.add(scanner.nextInt())
    }
    println("Danh sách ban đầu: $array")
    // Thêm phần tử
    println("Nhập vị trí cần thêm:")
    val addPosition = scanner.nextInt()
    println("Nhập giá trị cần thêm:")
    val addValue = scanner.nextInt()

    if (addPosition in 0..array.size) {
        array.removeAt(addPosition)
        array.add(addPosition, addValue)
        println("Danh sách sau khi thêm: $array")
    } else {
        println("Vị trí không hợp lệ")
    }

    println("Nhập m :")
    val m = scanner.nextInt()
    if(m in array.indices){
       array.removeAt(m)
    }else{
        println("Vị trí không hợp lệ")
    }
    println(array)
}