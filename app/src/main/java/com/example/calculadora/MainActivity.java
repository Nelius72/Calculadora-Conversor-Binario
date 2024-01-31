package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Variables
    private Button cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, coma, igual, sumar, restar,
            multiplicar, dividir, porcentaje, delete, ce, and, or, xor, not;
    private TextView resultado, operacion;
    private RadioButton binario, decimal;
    private String almacen, signo;
    double num1, num2, result;
    int bin1, bin2, binRes;
    String numeroNot= "";
    String numeroRes="";
    boolean comp = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cero = (Button) findViewById(R.id.button0);
        uno = (Button) findViewById(R.id.uno);
        dos = (Button) findViewById(R.id.dos);
        tres = (Button) findViewById(R.id.tres);
        cuatro = (Button) findViewById(R.id.cuatro);
        cinco = (Button) findViewById(R.id.cinco);
        seis = (Button) findViewById(R.id.seis);
        siete = (Button) findViewById(R.id.siete);
        ocho = (Button) findViewById(R.id.ocho);
        nueve = (Button) findViewById(R.id.nueve);
        sumar = (Button) findViewById(R.id.suma);
        restar = (Button) findViewById(R.id.resta);
        multiplicar = (Button) findViewById(R.id.multiplicar);
        dividir = (Button) findViewById(R.id.dividir);
        porcentaje = (Button) findViewById(R.id.porc);
        delete = (Button) findViewById(R.id.delete);
        ce = (Button) findViewById(R.id.botonC);
        coma = (Button) findViewById(R.id.coma);
        igual = (Button) findViewById(R.id.igual);
        resultado = (TextView) findViewById(R.id.textView);
        operacion = (TextView) findViewById(R.id.textView2);
        binario = (RadioButton) findViewById(R.id.radioButton);
        decimal = (RadioButton) findViewById(R.id.radioButton2);
        and = (Button) findViewById(R.id.and);
        or = (Button) findViewById(R.id.or);
        xor = (Button) findViewById(R.id.xor);
        not = (Button) findViewById(R.id.not);


//EMPEZAMOS CON EL RADIO BUTTON DECIMAL. SE PODRIA PONER QUE POR DEFECTO ESTÉ SELECCIONADO
        //Si está checked se realizan todas las operaciones, no hay que modificar nada
        //Si el botón está señalado, me puedes hacer todas las operaciones

        binario.setOnClickListener(view -> {
            if (comp != true) { //Boolean para evitar que al pulsar repetidamente el botón de binario se produzcan
                //sucesivas conversiones del número almacenado
                comp = true;
                dos.setEnabled(false);
                tres.setEnabled(false);
                cuatro.setEnabled(false);
                cinco.setEnabled(false);
                seis.setEnabled(false);
                siete.setEnabled(false);
                ocho.setEnabled(false);
                nueve.setEnabled(false);
                coma.setEnabled(false);
                and.setVisibility(View.VISIBLE);
                or.setVisibility(View.VISIBLE);
                xor.setVisibility(View.VISIBLE);
                not.setVisibility(View.VISIBLE);
                operacion.setText("");
                resultado.setText(Integer.toBinaryString((int) (Double.parseDouble(resultado.getText() + ""))));
                if (resultado.getText().length() > 6 && resultado.getText().length() < 12) {
                    resultado.setTextSize(60);
                } else if (resultado.getText().length() >= 12) {
                    resultado.setTextSize(40);
                } else {
                    resultado.setTextSize(90);
                }
            }

        });
        decimal.setOnClickListener(view -> {
            if (comp != false) {
                comp = false;
                dos.setEnabled(true);
                tres.setEnabled(true);
                cuatro.setEnabled(true);
                cinco.setEnabled(true);
                seis.setEnabled(true);
                siete.setEnabled(true);
                ocho.setEnabled(true);
                nueve.setEnabled(true);
                coma.setEnabled(true);
                and.setVisibility(View.INVISIBLE);
                or.setVisibility(View.INVISIBLE);
                xor.setVisibility(View.INVISIBLE);
                not.setVisibility(View.INVISIBLE);
                resultado.setText(String.valueOf(Integer.parseInt(resultado.getText() + "", 2)));
                if (resultado.getText().length() > 6 && resultado.getText().length() < 12) {
                    resultado.setTextSize(60);
                } else if (resultado.getText().length() >= 12) {
                    resultado.setTextSize(40);
                } else {
                    resultado.setTextSize(90);
                }
            }
        });


        //Números

        cero.setOnClickListener(view -> { //Cuando clickee el boton, me muestra el contenido del corchete
            almacen = operacion.getText().toString(); //Almacenamos en el string almacen el valor que le hemos asignado al pulsar el boton, en este caso 0
            operacion.setText(operacion.getText() + "0");
        });
        uno.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + "1");
        });
        dos.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + "2");
        });
        tres.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + "3");
        });
        cuatro.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + "4");
        });
        cinco.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + "5");
        });
        seis.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + "6");
        });
        siete.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + "7");
        });
        ocho.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + "8");
        });
        nueve.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + "9");
        });
        coma.setOnClickListener(view -> {
            almacen = operacion.getText().toString();
            operacion.setText(operacion.getText() + ".");
        });

        //Operandos

        sumar.setOnClickListener(view -> {
            try {

                signo = "+";
                almacen = operacion.getText().toString();
                if (!binario.isChecked()) {
                    num1 = Double.parseDouble(almacen);
                } else {
                    bin1 = Integer.parseInt(almacen, 2);//Convierto en int indicando binario
                }
                operacion.setText("");

            } catch (Exception ex) {
            }
        });
        restar.setOnClickListener(view -> {
            try {
                signo = "-";
                almacen = operacion.getText().toString();
                if (!binario.isChecked()) {
                    num1 = Double.parseDouble(almacen);
                } else {
                    bin1 = Integer.parseInt(almacen, 2);
                }
                operacion.setText("");
            } catch (Exception ex) {
            }
        });
        multiplicar.setOnClickListener(view -> {//REDONDEAR EL RESULTADO A LOS DOS PRIMEROS DECIMALES
            try {
                signo = "x";
                almacen = operacion.getText().toString();
                if (!binario.isChecked()) {
                    num1 = Double.parseDouble(almacen);
                } else {
                    bin1 = Integer.parseInt(almacen, 2);
                }
                operacion.setText("");
            } catch (Exception ex) {
            }
        });
        dividir.setOnClickListener(view -> {
            try {
                signo = "÷";
                almacen = operacion.getText().toString();
                if (!binario.isChecked()) {
                    num1 = Double.parseDouble(almacen);
                } else {
                    bin1 = Integer.parseInt(almacen, 2);
                }
                operacion.setText("");
            } catch (Exception ex) {
            }
        });
        porcentaje.setOnClickListener(view -> {
            try {
                signo = "%";
                almacen = operacion.getText().toString();
                if (!binario.isChecked()) {
                    num1 = Double.parseDouble(almacen);
                } else {
                    bin1 = Integer.parseInt(almacen, 2);
                }
                operacion.setText("");
            } catch (Exception ex) {
            }
        });

        and.setOnClickListener(view -> {
            try {
                signo = "&";
                almacen = operacion.getText().toString();
                if (binario.isChecked()) {
                    bin1 = Integer.parseInt(almacen, 2);
                }
                operacion.setText("");
            } catch (Exception ex) {
            }
        });

        or.setOnClickListener(view -> {
            try {
                signo = "|";
                almacen = operacion.getText().toString();
                if (binario.isChecked()) {
                    bin1 = Integer.parseInt(almacen, 2);
                }
                operacion.setText("");
            } catch (Exception ex) {
            }
        });

        xor.setOnClickListener(view -> {
            try {
                signo = "^";
                almacen = operacion.getText().toString();
                if (binario.isChecked()) {
                    bin1 = Integer.parseInt(almacen, 2);
                }
                operacion.setText("");
            } catch (Exception ex) {
            }

        });

        not.setOnClickListener(view -> {
            try {
                almacen = operacion.getText().toString();
                if (binario.isChecked()) {
                    for (int i = 0; i < almacen.length(); i++) {
                        char caracter = almacen.charAt(i);
                        if (caracter == '0') {
                            numeroNot = numeroNot + '1';
                        } else
                            numeroNot = numeroNot + '0';
                    }
                    resultado.setText(numeroNot);
                    numeroNot = "";
                }
                operacion.setText("");
            } catch (Exception ex) {
            }
        });

        ce.setOnClickListener(view -> {
            operacion.setText("0");
        });

        delete.setOnClickListener(view -> {
            try {
                String numero = operacion.getText() + "";
                operacion.setText(numero.substring(0, numero.length() - 1));
            } catch (Exception ex) {
            }
        });

        igual.setOnClickListener(view -> {
            try {
                almacen = operacion.getText().toString();
                if (!binario.isChecked()) {
                    num2 = Double.parseDouble(almacen);
                } else {
                    bin2 = Integer.parseInt(almacen, 2);
                }
                if (signo.equals("+")) {
                    operacion.setText("");
                    if (!binario.isChecked()) {
                        result = num1 + num2;
                    } else {
                        binRes = bin1 + bin2;
                    }
                }
                if (signo.equals("-")) {
                    operacion.setText("");
                    if (!binario.isChecked()) {
                        result = num1 - num2;
                    } else {
                        binRes = bin1 - bin2;
                    }
                }
                if (signo.equals("x")) {
                    operacion.setText("");
                    if (!binario.isChecked()) {
                        result = (num1 * num2) * 100.0 / 100.0;//Redondeo a dos decimales
                    } else {
                        binRes = bin1 * bin2;
                    }
                }
                if (signo.equals("÷")) {
                    operacion.setText("");
                    if (!binario.isChecked()) {
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            Toast.makeText(this, "No se puede dividir por 0", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        binRes = bin1 / bin2;
                    }
                }
                if (signo.equals("%")) {
                    operacion.setText("");
                    if (!binario.isChecked()) {
                        result = (num1 / 100 * num2); //Redondeo a dos decimales
                    } else {
                        binRes = bin1 / 100 * bin2;
                    }
                }
                if (signo.equals("&")) {
                    operacion.setText("");
                    if (binario.isChecked()) {
                        binRes = bin1 & bin2;
                    }
                }
                if (signo.equals("|")) {
                    operacion.setText("");
                    if (binario.isChecked()) {
                        binRes = bin1 | bin2;
                    }
                }
                if (signo.equals("^")) {
                    operacion.setText("");
                    if (binario.isChecked()) {
                        binRes = bin1 ^ bin2;
                    }
                }
                if (!binario.isChecked()) {
                    resultado.setText(String.valueOf(result));

                } else if (binario.isChecked()) {
                    String linea = Integer.toBinaryString(binRes);
                    resultado.setText(linea);
                }
                if (resultado.getText().length() > 6 && resultado.getText().length() < 12) {
                    resultado.setTextSize(60);
                } else if (resultado.getText().length() >= 12) {
                    resultado.setTextSize(40);
                } else {
                    resultado.setTextSize(90);
                }
                numeroRes= resultado.getText()+"";/////////////////////
                operacion.setText(numeroRes);//////////////////


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
