package sur.softsurena.utilidades.digitalPersonal.enrollment;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import java.awt.Frame;
import javax.swing.JOptionPane;

public final class EnrollmentForm extends CaptureForm {

    private static final long serialVersionUID = 1L;

    private transient final DPFPEnrollment enroller = DPFPGlobal.getEnrollmentFactory().createEnrollment();

    EnrollmentForm(Frame owner) {
        super(owner);
    }

    @Override
    protected void init() {
        super.init();
        this.setTitle("Inscripcion de huella dactilares.");
        updateStatus();
    }

    @Override
    protected void process(DPFPSample sample) {
        super.process(sample);
        // Process the sample and create a feature set for the enrollment purpose.
        DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Check quality of the sample and add to enroller if it's good
        if (features != null) {
            try {
                enroller.addFeatures(features);		// Add feature set to template.
                makeReport("Se creó el conjunto de características de huellas dactilares.");
            } catch (DPFPImageQualityException ex) {
            } finally {
                updateStatus();

                // Check if template has been created.
                switch (enroller.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY -> {
                        // report success and stop capturing
                        stop();
                        ((MainForm) getOwner()).setTemplate(enroller.getTemplate());
                        setPrompt("Haga clic en Cerrar y, a continuación, haga clic en Verificación de huellas dactilares.");
                        
                    }

                    case TEMPLATE_STATUS_FAILED -> {
                        // report failure and restart capturing
                        enroller.clear();
                        stop();
                        updateStatus();
                        ((MainForm) getOwner()).setTemplate(null);
                        JOptionPane.showMessageDialog(
                                EnrollmentForm.this,
                                "La plantilla de huellas dactilares no es válida. Repita el registro de huellas dactilares.",
                                "Inscribir huella dactilar.",
                                JOptionPane.ERROR_MESSAGE
                        );
                        start();
                    }
                }
            }
        }
    }

    private void updateStatus() {
        // Show number of samples needed.
        setStatus(String.format("Muestras de huellas dactilares necesarias: %1$s", enroller.getFeaturesNeeded()));
    }

}
