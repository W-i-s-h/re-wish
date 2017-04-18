package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Controller {



    public SerialPort serialPort;                     /*—Создаем объект типа SerialPort*/
    public String a;                                  /*создаем стоковую переменную для храния значения*/
    public Button butt1;
    public Button butt11;
    public Label labdata;
    byte[] buffer;


    public void letsCOM() throws SerialPortException {                          /*метод открывающий порт*/

        try {
            serialPort = new SerialPort("COM3");                              /*ставим интересующий нас порт*/
//            serialPort = new SerialPort("/dev/cu.usbmodem1431");                    /*или этот. В зависимости от системы*/
            serialPort.openPort();                                                    /*открываем порт*/
            serialPort.setParams(9600, 8, 1, 0);    /*после открытия порта обязательно указываем параметры*/
            labdata.setText("Порт открыт успешно");
        } catch (SerialPortException e) {
            e.printStackTrace();
            labdata.setText("Порт не открыт");
        }

    }

    public void letsSend() throws SerialPortException {                     /*метод ждущий принимающий 10 байт*/
        try {
//            buffer = serialPort.readBytes(2);
            a = serialPort.readString(10);                        /*читаем данные из порта в созданную ранее переменную*/
//            serialPort.closePort();
            System.out.println(a);
            labdata.setText("Данные приняты успешно");
        } catch (SerialPortException ex) {
            System.out.println(ex);
            labdata.setText("Данные неприняты");
//            serialPort.closePort();
        }
    }

    public void letsClose() throws SerialPortException {                     /*метод закрывающий порт*/
        try {
            serialPort.closePort();
            labdata.setText("Порт закрыт успешно");
        } catch (SerialPortException e) {
            e.printStackTrace();
            labdata.setText("Порт или уже закрыт или не закрыт");
        }

    }

    public void letsDate() {                                                /*отображаем данные в поле Данные: */
        labdata.setText("Данные: " + a);
    }



//      Предыдущие неудачне попытки, но надо все разобрать. Потому что все должно работать

//        String name ="Test";
//        byte[] a = name.getBytes();
//        System.out.println(name.getBytes());
//        System.out.println(a);
//
//        String str = new String(a);
//        System.out.println(str);

//        SerialPort serialPort = new SerialPort("/dev/ttyS0");
//        try {
//            serialPort.openPort();
//            serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//            serialPort.writeBytes("A".getBytes());
//
//
//            byte[] buffer = serialPort.readBytes(2);
//
//            FileWriter fw1 = new FileWriter("/home/pi/Desktop/AGOT.txt", true);
//            fw1.write(buffer.toString());
//            fw1.append(buffer.toString());
//            fw1.flush();
//
//            System.out.println(buffer);
//            serialPort.closePort();
//        }
//        catch (SerialPortException ex) {
//            System.out.println(ex);
//        }
//    }


//        openPort();
//        serialPort.writeBytes("A".getBytes());
//        serialPort.setEventsMask(SerialPort.MASK_RXCHAR); /*Устанавливаем маску или список события на которые будет происходить реакция. В данном случае это приход данных в буффер порта*/
//        serialPort.addEventListener(new EventListener()); /*Передаем экземпляр класса EventListener порту, где будет обрабатываться события. Ниже описан класс*/
//
//        }
//
//
//    public void openPort() throws SerialPortException {
//        serialPort = new SerialPort("/dev/ttys000");
//        serialPort.openPort();
//        serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//    }
//
//    public void portClose() throws SerialPortException {
//        serialPort.closePort();
//    }
//
//    public class EventListener implements SerialPortEventListener { /*Слушатель срабатывающий по появлению данных на COM-порте*/
//        public void serialEvent(SerialPortEvent event) {
//            if (event.isRXCHAR() && event.getEventValue() > 0) { /*Если происходит событие установленной маски и количество байтов в буфере более 0*/
//                try {
//                    data = serialPort.readString(event.getEventValue()); /*Создаем строковую переменную  data, куда и сохраняем данные*/
//                    try (FileWriter fw1 = new FileWriter("/home/pi/Desktop/test.txt", true)) {
//                        String text = data;
//                        fw1.write(text);
//                        fw1.append('\n');
//
//                        fw1.flush();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.print(data);/*Выводим данные на консоль*/
//                    System.out.println("Вывожу данные на экран " + data);
//                    serialPort.closePort();
//                } catch (SerialPortException ex) {
//                    System.out.println(ex);
//                }
//            }
//        }
//    }

    public void exit() {
        Stage stage = (Stage)butt11.getScene().getWindow();
        stage.close();
    }
}