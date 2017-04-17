package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Controller {
    public Button com;
    public SerialPort serialPort;
    public Button com1;
    public Label lab1;
    public String a;

    public void letsCOM() {

                SerialPort serialPort = new SerialPort("/dev/ttyS0");
                try {
                    serialPort.openPort();
                    serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//                    byte[] buffer = serialPort.readBytes(2);
                    a = serialPort.readString(1);
                    serialPort.closePort();
                    System.out.println(a);

                }
                catch (SerialPortException ex) {
                    System.out.println(ex);
                }
            }

    public void letsData() {
        lab1.setText("Данные: " + a);
    }
        }

//        SerialPort serialPort = new SerialPort("COM6");
//        try {
//            serialPort.openPort();
//            serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//            String a = "test";
//            serialPort.writeBytes(a.getBytes());
//            serialPort.closePort();
//            System.out.println(a);
//        }
//        catch (SerialPortException ex) {
//            System.out.println(ex);
//        }
//    }
//}
//        serialPort = new SerialPort("COM3");
//        try {
//            serialPort.openPort();
//            serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//            serialPort.setEventsMask(SerialPort.MASK_RXCHAR);
//            serialPort.addEventListener(new EventListener());
//        }
//        catch (SerialPortException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    private class EventListener implements SerialPortEventListener {
//
//        public void serialEvent(SerialPortEvent event) {
//            if(event.isRXCHAR() && event.getEventValue() == 8){
//                try {
//                    byte[] buffer = serialPort.readBytes(8);
//                    serialPort.closePort();
//                    System.out.println(buffer);
//                }
//                catch (SerialPortException ex) {
//                    System.out.println(ex);
//                }
//            }
//        }
//    }
//}