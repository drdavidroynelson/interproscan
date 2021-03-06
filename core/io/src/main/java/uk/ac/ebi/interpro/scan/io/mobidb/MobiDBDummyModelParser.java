package uk.ac.ebi.interpro.scan.io.mobidb;

import uk.ac.ebi.interpro.scan.io.AbstractModelFileParser;
import uk.ac.ebi.interpro.scan.model.Model;
import uk.ac.ebi.interpro.scan.model.Signature;
import uk.ac.ebi.interpro.scan.model.SignatureLibraryRelease;

import java.io.IOException;

/**
 * @author Gift Nuka
 *
 */
public class MobiDBDummyModelParser extends AbstractModelFileParser {

    private static final String MOBIDB_SIGNATURE_ACCESSION = "mobidb-lite";

    private static final String MOBIDB_SIGNATURE_NAME = "disorder_prediction";

    private static final String MOBIDB_SIGNATURE_DESC = "consensus disorder prediction";

    /**
     * This is rather badly named as there is nothing to parse...
     * <p/>
     * however, the point is that it returns a SignatureLibraryRelease for MOBIDB,
     * containing one big fat Signature called "mobidb-lite".
     *
     * @return a complete SignatureLibraryRelease object
     */
    @Override
    public SignatureLibraryRelease parse() throws IOException {

        final SignatureLibraryRelease release = new SignatureLibraryRelease(
                this.getSignatureLibrary(),
                this.getReleaseVersionNumber());

        final Model model = new Model(MOBIDB_SIGNATURE_ACCESSION, MOBIDB_SIGNATURE_NAME, MOBIDB_SIGNATURE_DESC);
        final Signature.Builder builder = new Signature.Builder(MOBIDB_SIGNATURE_ACCESSION);
        final Signature signature = builder.name(MOBIDB_SIGNATURE_NAME)
                .description(MOBIDB_SIGNATURE_DESC)
                .model(model)
                .signatureLibraryRelease(release).build();

        release.addSignature(signature);
        return release;
    }
}
