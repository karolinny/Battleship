import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import excecao.ResponseValidatorException;

public class ResponseValidator {

	public static void valid(InputStream in) throws ResponseValidatorException {
		try {
			byte[] b = new byte[1];
			in.read(b);
			String r = new String(b);
			if (!("0".equals(r) || "1".equals(r))) {
				throw new ResponseValidatorException(
						"Entrada diferente de 0 ou 1");
			}
		}

		catch (IOException e) {
			throw new ResponseValidatorException("ERRO");
		}

	}

	public static void valid(String value) throws ResponseValidatorException {
		if (!("0".equals(value) || "1".equals(value))) {
			throw new ResponseValidatorException(
					"Entrada diferente de 0 ou 1");
		}
	}

}
