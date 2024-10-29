package com.example.calculadoralocaclaudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculadora()
        }
    }
}

@Composable
fun Calculadora() {
    var displayText by remember { mutableStateOf("") }
    var expression by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = displayText,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color(0xFF333333), shape = MaterialTheme.shapes.medium)
                .padding(16.dp),
            textAlign = TextAlign.End
        )

        val BUTTON_FONT_SIZE = 18.sp

        fun evaluateExpression(expression: String): String {
            return try {
                var total = 0.0
                var currentNumber = ""
                var lastOperator = '+'

                for (char in expression) {
                    when {
                        char.isDigit() || char == '.' -> {
                            currentNumber += char
                        }
                        char == '+' || char == '-' || char == '*' || char == '/' -> {
                            if (currentNumber.isNotEmpty()) {
                                total = when (lastOperator) {
                                    '+' -> total + currentNumber.toDouble()
                                    '-' -> total - currentNumber.toDouble()
                                    '*' -> total * currentNumber.toDouble()
                                    '/' -> total / currentNumber.toDouble()
                                    else -> total
                                }
                            }
                            lastOperator = char
                            currentNumber = ""
                        }
                    }
                }

                if (currentNumber.isNotEmpty()) {
                    total = when (lastOperator) {
                        '+' -> total + currentNumber.toDouble()
                        '-' -> total - currentNumber.toDouble()
                        '*' -> total * currentNumber.toDouble()
                        '/' -> total / currentNumber.toDouble()
                        else -> total
                    }
                }
                if (total.toString().contains('5')) {
                    return total.toString().replace('5', '6')
                }
                total.toString()
            } catch (e: Exception) {
                "Error"
            }
        }

        // FILA 1 -------------------------------------------------------------------------
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = { if (expression.isNotEmpty()) {
                    expression = expression.dropLast(1)
                    displayText = expression.ifEmpty { "" }
                }}
            ) {
                Text(text = "DEL", fontSize = BUTTON_FONT_SIZE)
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = { expression = ""
                            displayText = "" }
            ) {
                Text(text = "C", fontSize = BUTTON_FONT_SIZE)
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression += "*"
                    displayText += "x"
                }
            ) {
                Text(text = "x", fontSize = BUTTON_FONT_SIZE)
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression += "-"
                    displayText += "-"
                }
            ) {
                Text(text = "-", fontSize = BUTTON_FONT_SIZE)
            }
        }
//FILA 2 ----------------------------------------------------------------------
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression +="3"
                    displayText+="3"

                }
            ) {
                Text(
                    text = "1",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression +="4"
                    displayText+="4"
                }
            ) {
                Text(
                    text = "2",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression +="7"
                    displayText+="7"
                }
            ) {
                Text(
                    text = "3",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    //TODO
                    expression +='+'
                    displayText+="+"
                }
            ) {
                Text(
                    text = "+",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }
        }

//FILA 3 ----------------------------------------------------------------------
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression +="6"
                    displayText+="6"
                }
            ) {
                Text(
                    text = "4",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression +="8"
                    displayText+="8"
                }
            ) {
                Text(
                    text = "6",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression +="9"
                    displayText+="9"
                }
            ) {
                Text(
                    text = "7",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    //TODO
                    expression +="/"
                    displayText+="/"
                }
            ) {
                Text(
                    text = "/",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }
        }

//FILA 4 ----------------------------------------------------------------------
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression +="0"
                    displayText+="0"
                }
            ) {
                Text(
                    text = "8",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression +="1"
                    displayText+="1"
                }
            ) {
                Text(
                    text = "9",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    expression +="2"
                    displayText+="2"
                }
            ) {
                Text(
                    text = "0",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    //TODO
                    displayText = evaluateExpression(expression)

                }
            ) {
                Text(
                    text = "=",
                    fontSize = BUTTON_FONT_SIZE,
                    modifier = Modifier.wrapContentSize()
                )
            }
        }

    }


}

