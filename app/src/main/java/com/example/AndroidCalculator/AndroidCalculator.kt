package com.example.AndroidCalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.example.AndroidCalculator.R
import android.widget.Toast
import org.w3c.dom.Text
import java.math.BigDecimal
import java.util.*

class AndroidCalculator : AppCompatActivity(), View.OnClickListener {

    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)                                            //调用父类Activity的onCreate ()方法
        setContentView(R.layout.first_layout)                                        //采用first_layout布局文件进行布局
        editText = findViewById(R.id.edit_text) as EditText
        val button1 = findViewById(R.id.button_1) as Button                         //获取button_1转换为button类型
        val button2 = findViewById(R.id.button_2) as Button
        val button3 = findViewById(R.id.button_3) as Button
        val button4 = findViewById(R.id.button_4) as Button
        val button5 = findViewById(R.id.button_5) as Button
        val button6 = findViewById(R.id.button_6) as Button
        val button7 = findViewById(R.id.button_7) as Button
        val button8 = findViewById(R.id.button_8) as Button
        val button9 = findViewById(R.id.button_9) as Button
        val button0 = findViewById(R.id.button_0) as Button
        val button_add = findViewById(R.id.button_add) as Button
        val button_sub = findViewById(R.id.button_sub) as Button
        val button_mul = findViewById(R.id.button_mul) as Button
        val button_div = findViewById(R.id.button_div) as Button
        val button_del = findViewById(R.id.button_del) as Button
        val button_neg = findViewById(R.id.button_neg) as Button
        val button_equ = findViewById(R.id.button_equ) as Button
        val button_pt = findViewById(R.id.button_pt) as Button
        val button_pc = findViewById(R.id.button_pc) as Button
        val button_fac = findViewById(R.id.button_fac) as Button
        val button_c = findViewById(R.id.button_c) as Button
        val button_root = findViewById(R.id.button_root) as Button
        val button_science = findViewById(R.id.button_science) as Button
        button0.setOnClickListener(this)                                                 //监听     this:当前类
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button_add.setOnClickListener(this)
        button_sub.setOnClickListener(this)
        button_mul.setOnClickListener(this)
        button_div.setOnClickListener(this)
        button_del.setOnClickListener(this)
        button_neg.setOnClickListener(this)
        button_equ.setOnClickListener(this)
        button_pt.setOnClickListener(this)
        button_pc.setOnClickListener(this)
        button_fac.setOnClickListener(this)
        button_c.setOnClickListener(this)
        button_root.setOnClickListener(this)
        button_science.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {                                //添加菜单
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {                            //事件处理
        when (item.itemId) {                                                                   //判断
            R.id.zhuye_item ->{                                                                //按zhuce按钮
                val intent = Intent(Intent.ACTION_VIEW)                                           //声明常量
                intent.data = Uri.parse("https://gitee.com/loganvon/AndroidCalculator")                 //跳转网页
                startActivity(intent)                                                              //启动
            }
            R.id.tuichu_item -> finish()                                                        //按退出按钮，结束
        }

        return true
    }

    override fun onClick(v: View?) {
        var et = editText.getText().toString()                                             //声明变量，获得string类型数据
        when (v?.getId()) {                                                                   //判断，获取当前组件id属性
            R.id.button_0 -> {                                                                 //为button_0
                if (et == "0") et = "0" else et += "0"                                         //如果变量为0，赋值为0，否则，变量=变量+0
                editText.setText(et)                                                          //输入框设置文本
            }
            R.id.button_1 -> {
                if (et == "0") et = "1" else et += "1"
                editText.setText(et)
            }
            R.id.button_2 -> {
                if (et == "0") et = "2" else et += "2"
                editText.setText(et)
            }
            R.id.button_3 -> {
                if (et == "0") et = "3" else et += "3"
                editText.setText(et)
            }
            R.id.button_4 -> {
                if (et == "0") et = "4" else et += "4"
                editText.setText(et)
            }
            R.id.button_5 -> {
                if (et == "0") et = "5" else et += "5"
                editText.setText(et)
            }
            R.id.button_6 -> {
                if (et == "0") et = "6" else et += "6"
                editText.setText(et)
            }
            R.id.button_7 -> {
                if (et == "0") et = "7" else et += "7"
                editText.setText(et)
            }
            R.id.button_8 -> {
                if (et == "0") et = "8" else et += "8"
                editText.setText(et)
            }
            R.id.button_9 -> {
                if (et == "0") et = "9" else et += "9"
                editText.setText(et)
            }
            R.id.button_pt -> if (et[et.length - 1] == '+' ||                                 //.按键    如果最后一个元素为+      或者
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.' ||
                (!et.contains("+") &&                                      //判断+是否在et中，存在返回false，不存在返回true
                !et.contains("-") &&
                !et.contains("×") &&
                !et.contains("÷") &&
                et.contains("."))                                       //判断.在et中，存在返回true，不存在返回false
            ) {
                Toast.makeText(this@AndroidCalculator,                          //显示bad input
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "."                                                      //et为.
                editText.setText(et)                                       //显示文本
            }


            R.id.button_add -> if (et[et.length - 1] == '+' ||                                    //+号，
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "+"
                editText.setText(et)
            }


            R.id.button_sub -> if (et[et.length - 1] == '+' ||                         //-号
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "-"
                editText.setText(et)
            }


            R.id.button_mul -> if (et[et.length - 1] == '+' ||                         //*号
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "×"
                editText.setText(et)
            }


            R.id.button_div -> if (et[et.length - 1] == '+' ||                          // /号
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ) {
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            } else {
                et += "÷"
                editText.setText(et)
            }


            R.id.button_science ->if (et[et.length - 1] == '+' ||                      //sin
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷' ||
                et[et.length - 1] == '.'
            ){
                Toast.makeText(this@AndroidCalculator,
                    "Bad Input!",
                    Toast.LENGTH_SHORT).show()
                editText.setText(et)
            }else{
                val jg = getResult()                                                     //声明常量      getResult：结果
                if (jg.contains("Infinity")) {                                       //如果是正无穷
                    Toast.makeText(                                                           //显示0不能当成被除数
                        this@AndroidCalculator,
                        "0 cannot be used as a divior!",
                        Toast.LENGTH_SHORT
                    ).show()
                    editText.setText("0")
                } else {                                                                   //否则
                    var kxs=jg.toDouble()                                                  //声明变量，转换为Double（双精度浮点型）型
                    kxs= Math.sin(Math.PI/(180/kxs))                                                     //sin算法
                    var kxsgf = formatResult(kxs)                                                     //转换格式
                    editText.setText(kxsgf)
                }
            }


            R.id.button_del -> {                                                           //del键
                et = if (et.length > 1) {                                                   //判断，如果et大于1
                    if (et.length == 2 && et[0] == '-') {                                   //判断，如果et大小为2且第一位为-
                        "0"                                                                 //显示0
                    } else et.substring(0, et.length - 1)                                   //否则  最后一位消失
                } else {
                    "0"
                }
                editText.setText(et)
            }


            R.id.button_c -> {                                                    //c键
                et = "0"                                                          //显示为0
                editText.setText(et)
            }


            R.id.button_equ -> if (et[et.length - 1] == '+' ||               //=号
                et[et.length - 1] == '-' ||
                et[et.length - 1] == '×' ||
                et[et.length - 1] == '÷') {
                Toast.makeText(
                    this@AndroidCalculator,
                    "Please complete the formula!",
                    Toast.LENGTH_SHORT
                ).show()
                editText.setText(et)
            } else {
                val res = getResult()                                              //声明变量
                if (res.contains("Infinity")) {                              //正无穷
                    Toast.makeText(
                        this@AndroidCalculator,
                        "0 cannot be used as a divior!",
                        Toast.LENGTH_SHORT
                    ).show()
                    editText.setText("0")
                } else {
                    editText.setText(res)
                }
            }


            R.id.button_pc -> {                                                //%号
                var per = et.toDouble()                                        //声明变量
                per = per / 100                                                //算法
                var per1 = "" + per                                            //开头为空
                per1 = per1.replace("0+?$".toRegex(), "")             //去掉多余的.0
                per1 = per1.replace("[.]$".toRegex(), "")              //去掉多余的.
                editText.setText(per1)
            }


            R.id.button_neg -> if (et[0] >= '0' && et[0] <= '9') {                         //+/-号
                if (et == "0") {
                    editText.setText("0")
                } else {
                    editText.setText("-$et")                                           //给与-号
                }
            } else if (et[0] == '-') editText.setText(                                //如果第一位为-
                et.substring(1, et.length)                                          //从第二位显示
            ) else editText.setText(et)


            R.id.button_fac -> if (et.contains(".")) {                            //！号       如果et包含.
                Toast.makeText(this@AndroidCalculator,
                    "Not integer!",
                    Toast.LENGTH_SHORT).show()
            } else if (et[0] == '-') {                                               //如果et第一位是-
                Toast.makeText(this@AndroidCalculator,
                    "Not positive!",
                    Toast.LENGTH_SHORT).show()
            } else {
                if (et == "0") {
                    et = "1"
                    editText.setText(et)
                } else {
                    val num = et.toInt().toDouble()                             //声明常量
                    var result = 1.0
                    var i = 1
                    while (i <= num) {                                    //阶乘算法
                        result = result * i
                        i++
                    }
                    var result1 = "" + result                                           //开头为空
                    result1 = result1.replace("0+?$".toRegex(), "")             //去掉多余的.0
                    result1 = result1.replace("[.]$".toRegex(), "")              //去掉多余的.
                    et = result1.toString()                              //转换类型
                    editText.setText(et)
                }
            }


            R.id.button_root -> if (et[0] == '-') {                               //√￣号           如果为-
                Toast.makeText(
                    this@AndroidCalculator,
                    "Negative numbers cannot be squared!",
                    Toast.LENGTH_SHORT
                ).show()
                editText.setText("0")
            } else if (et.contains("+") ||
                et.contains("-") ||
                et.contains("×") ||
                et.contains("÷")
            ) {
               var et = getResult()                            //把运算结果赋值给et
                var x = et.toDouble()                          //声明变量
                x = Math.sqrt(x)                                //根号算法
                var x2 = formatResult(x)                         //格式化结果
                editText.setText(x2)
            } else {
                var x = et.toDouble()                          //声明变量
                x = Math.sqrt(x)                                //根号算法
                var x2 = formatResult(x)                         //格式化结果
                editText.setText(x2)
            }
            else -> {
                Toast.makeText(this@AndroidCalculator,
                    "Unexpected error!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun formatResult(result: Double): String {
        var re = String.format("%.9f", result)                               //格式化
        re = re.replace("0+?$".toRegex(), "")                             //去掉多余的.0
        re = re.replace("[.]$".toRegex(), "")                             //去掉多余的.
        return re
    }

    fun getResult(): String {
        val infix = editText.getText().toString()                           //声明变量，获得string类型数据
        val postfix = toPostfix(infix)                                     //后缀表达式      中缀表达式
        val result = toValue(postfix)
        var re = formatResult(result)
        return re
    }

    //函数toPostfix(),用运算符栈来存运算符
    fun toPostfix(infix: String): StringBuffer {                                 // 中缀表达式转化成后缀表达式,把运算符进入到运算符栈
        val stack = Stack<String>()                                               //创建一个string类型的栈
        val postfix = StringBuffer(infix.length * 2)                      //声明一个StringBuffer常量
        var i = 0                                                                 //声明一个变量i    令i=0
        while (i < infix.length) {                                                //循环条件：i小于infix长度
            var ch = infix.get(i)                                                 //声明一个变量ch赋予infix的第i位
            when (ch) {                                                           //判断
                '+' -> {                                                          //为+时
                    while (!stack.isEmpty() && stack.peek() != "(")               // 如果栈不为空且栈顶不是（
                        postfix.append(stack.pop())                                // 追加  弹出的栈顶
                    stack.push(ch.toString() + "")                                //在堆栈顶部插入元素  入栈
                    i++                                                            //i+1
                }
                '-' -> if (i == 0) {                                               //如果此时i是第一位
                    postfix.append(0)                                               //在postfix后边添加0
                    postfix.append(" ")                                            //在postfix后边添加
                    stack.push("(")                                            //(入栈
                    stack.push(ch.toString() + "")                              //在堆栈顶部插入元素  入栈
                    i++                                                              //i+1
                } else {                                                             //否则
                    while (!stack.isEmpty() && stack.peek() != "(")                  // 如果栈不为空且栈顶不是（
                        postfix.append(stack.pop())                                  // 追加  弹出的栈顶
                    stack.push(ch.toString() + "")                              //在堆栈顶部插入元素  入栈
                    i++                                                              //i+1
                }
                '×', '÷' -> {
                    while (!stack.isEmpty() &&                                        // 如果栈不为空且
                        (stack.peek() == "×" || stack.peek() == "÷"))               //栈顶为*或/
                        postfix.append(stack.pop())                                // 追加  弹出的栈顶
                    stack.push(ch.toString() + "")                           //在堆栈顶部插入元素  入栈
                    i++                                                           //i+1
                }
                else -> if (i == 1 && infix.get(0) == '-') {                             //如果i为1且infix第一位为-
                    while (i < infix.length && ch >= '0' && ch <= '9' ||                 //i小于infix的长度且ch大于等于0且ch小于等于9 或
                        i < infix.length && ch == '.') {                                 //i小于infix的长度且ch=.
                        postfix.append(ch)                                                //在postfix后边添加ch
                        i++                                                               //i+1
                        if (i < infix.length)                                              //如果i小于infix长度
                            ch = infix.get(i)                                           //赋予ch当前数字
                    }
                    postfix.append(" ")                                              //在postfix后添加
                    postfix.append('-')                                              //在postfix后添加-，否则结果没有负号
                    stack.pop()                                                      //出栈，删除最顶部元素
                    stack.pop()                                                      //出栈，删除最顶部元素
                } else {                                                              //否则
                    while (i < infix.length && ch >= '0' && ch <= '9' ||                      //i小于infix的长度且ch大于等于0且ch小于等于9 或
                        i < infix.length && ch == '.') {                                          //i小于infix的长度且ch=.
                        postfix.append(ch)                                                         //在postfix后边添加ch
                        i++                                                                      //i+1
                        if (i < infix.length) ch = infix.get(i)                               //如果i小于infix长度 ，赋予ch当前数字
                    }
                    postfix.append(" ")                                                        //在postfix后添加
                }
            }

        }
        while (!stack.isEmpty())                                                             //如果栈不为空
            postfix.append(stack.pop())                                                       //追加 弹出的栈顶
        return postfix                                                                      //返回postfix的值
    }


    //函数toValue(),用操作数栈来存数字
    fun toValue(postfix: StringBuffer): Double {                              //创建函数toValue()
        val stack = Stack<Double>()                                            //创建一个double类型的栈
        var value = 0.0                                                        //声明变量value为0.0
        var j = 0                                                              //声明变量j为0
        var i = 0                                                              //声明变量i为0
        while (i < postfix.length) {                                                 //循环  i<postfix长度
            j = i                                                                      //把j的值赋予i
            var ch = postfix.get(i)                                                     //声明变量ch赋予postfix的第i位
            if (ch >= '0' && ch <= '9' || ch == '.') {                                  //如果ch在0-9之间或为.
                value = 0.0                                                              //初始值为0
                while (ch != ' ') {                                                       //循环，ch不为空
                    while (ch != ' ' && ch != '.') {                                        //循环，ch不为空以及ch不为.
                        value = value * 10.0 + (ch - '0').toDouble()                         // 字符转化为数值
                        j++                                                                  //j+1
                        ch = postfix.get(++i)                                               //赋予ch  i+1的值
                    }
                    if (ch != ' ' && ch == '.')                                         //如果ch不为空且为.
                        ch = postfix.get(++i)                                            //赋予chi   +1的值
                    while (ch != ' ' && i >= j + 1) {                                     //当ch不为空，且i大于j+1
                        val valueBD = BigDecimal(value.toString())                       //将String表示形式转换成BigDecimal
                        val chBD = BigDecimal(ch - '0')                                //赋予chBD   BigDecimal第0位的值
                        val nBD = BigDecimal(Math.pow(10.0, (i - j).toDouble()))                 //10的几次幂
                        val temp = chBD.divide(nBD)                                        //赋予temp  chBD除以nBD的值
                        value = valueBD.add(temp).toDouble()                               //此时value值为 Double型的添加了temp值的valueBD值
                        ch = postfix.get(++i)                                              //ch为postfix的i+1位
                    }
                    stack.push(value)                                              //入栈
                }
            } else {                                                                 //否则
                if (ch != ' ') {                                                    //如果ch不为空
                    var y: Double = stack.pop()                                    //声明y，删除栈顶并返回
                    var x: Double = stack.pop()                                    //声明x，删除栈顶并返回
                    value = when (ch) {                                            //赋值value   判断
                        '+' -> x + y                                                //为+时，x+y
                        '-' -> x - y                                                //为-时，x-y
                        '×' -> x * y                                                //为*时，x*y
                        '÷' -> x / y                                                //为÷时，x/y
                        else -> 0.0                                                 //否则  为0
                    }
                    stack.push(value)                                                  //value值入栈
                }
            }
            i++                                                                          //i+1
        }
        return stack.pop()                                                                //删除栈顶值并返回
    }

}