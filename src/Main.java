import javax.sound.midi.*;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args){

    }

    public void MidiHandler(){
        MidiDevice midiDevice;
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();

        for(int i = 0; i < infos.length; i++){
            try{
                midiDevice = MidiSystem.getMidiDevice(infos[i]);
                System.out.println(infos[i]);

                List<Transmitter> transmitters = midiDevice.getTransmitters();

                for(int j= 0; j<transmitters.size(); j++){
                    transmitters.get(j).setReceiver(new MyReceiver(midiDevice.getDeviceInfo().toString()));
                }

                Transmitter transmitter = midiDevice.getTransmitter();
                transmitter.setReceiver(new MyReceiver(midiDevice.getDeviceInfo().toString()));

                midiDevice.open();
                System.out.println(midiDevice.getDeviceInfo()+" opened");
            }catch(MidiUnavailableException e){}
        }

    }

    public class MyReceiver implements Receiver{
        public String name;
        public MyReceiver (String name){
            this.name=name;
        }
        public void send(MidiMessage message, long timeStamp){
            System.out.println("Received");
        }
        public void close(){}


    }

}
