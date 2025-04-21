package sur.softsurena.utilidades.digitalPersonal.uISupport;

import java.util.EnumMap;

import com.digitalpersona.onetouch.DPFPFingerIndex;

class Utilities {

    private static final EnumMap<DPFPFingerIndex, String> fingerNames;
    static {
    	fingerNames = new EnumMap<DPFPFingerIndex, String>(DPFPFingerIndex.class);
    	fingerNames.put(DPFPFingerIndex.LEFT_PINKY,   "Izquierdo Meñique");
    	fingerNames.put(DPFPFingerIndex.LEFT_RING,    "Izquierdo Anular");
    	fingerNames.put(DPFPFingerIndex.LEFT_MIDDLE,  "Izquierdo Dedo medio");
    	fingerNames.put(DPFPFingerIndex.LEFT_INDEX,   "Izquierdo Indice");
    	fingerNames.put(DPFPFingerIndex.LEFT_THUMB,   "Izquierdo Pulgar");
    	
    	fingerNames.put(DPFPFingerIndex.RIGHT_PINKY,  "Derecho Meñique");
    	fingerNames.put(DPFPFingerIndex.RIGHT_RING,   "Derecho Anular");
    	fingerNames.put(DPFPFingerIndex.RIGHT_MIDDLE, "Derecho Dedo medio");
    	fingerNames.put(DPFPFingerIndex.RIGHT_INDEX,  "Derecho Indice");
    	fingerNames.put(DPFPFingerIndex.RIGHT_THUMB,  "Derecho Pulgar");
    }

    public static String fingerName(DPFPFingerIndex finger) {
    	return fingerNames.get(finger); 
    }
    public static String fingerprintName(DPFPFingerIndex finger) {
    	return fingerNames.get(finger) + " Huella dactilar"; 
    }
    
}
