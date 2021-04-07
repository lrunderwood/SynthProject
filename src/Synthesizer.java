import javax.sound.midi.*;
import java.util.List;
import java.util.*;

public class Synthesizer {

    public static void main(String[] args){
        ShortMessage myMsg = new ShortMessage();

        try {
            myMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 93);
        }catch(InvalidMidiDataException e){
            System.out.println("Invalid Midi Data Exception");
        }
        long timeStamp = -1;
        
        //Open receiver
        try {
            Receiver rcvr = MidiSystem.getReceiver();
            rcvr.send(myMsg, timeStamp);
        }catch(MidiUnavailableException e){
            System.out.println("Midi Unavailable Exception");
        }

    }


}
