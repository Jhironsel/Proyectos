package sur.softsurena.utilidades.digitalPersonal.enrollment;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Frame;
import java.util.Objects;


public final class VerificationForm extends CaptureForm
{

    private static final long serialVersionUID = 1L;
	private transient final DPFPVerification verificator = DPFPGlobal.getVerificationFactory().createVerification();
	private transient DPFPTemplate template;
	VerificationForm(Frame owner) {
		super(owner);
                this.template = null;
	}
        
        public VerificationForm(Frame owner, DPFPTemplate template) {
		super(owner);
                this.template = template;
	}
	
	@Override protected void init()
	{
		super.init();
		this.setTitle("Inscripcion de huellas dactilares.");
		updateStatus(0);
	}

	@Override protected void process(DPFPSample sample) {
		super.process(sample);

		// Process the sample and create a feature set for the enrollment purpose.
		DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

                if(Objects.nonNull(((MainForm) getOwner()).getTemplate()))
                    template = ((MainForm) getOwner()).getTemplate();
                
		// Check quality of the sample and start verification if it's good
		if (features != null)
		{
			// Compare the feature set with our template
			DPFPVerificationResult result = 
				verificator.verify(features, template);
			updateStatus(result.getFalseAcceptRate());
			if (result.isVerified())
				makeReport("La huella dactilar fue verificada. COINCIDEN");
			else
				makeReport("La huella dactilar NO FUE verificada.");
		}
	}
	
	private void updateStatus(int FAR)
	{
		// Show "False accept rate" value
		setStatus(String.format("Tasa de aceptación falsa (FAR) = %1$s", FAR));
	}

}
