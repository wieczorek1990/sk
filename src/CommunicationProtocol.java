public class CommunicationProtocol {
	private static final int WAITING = 0;
	private static final int TRANSMISION = 1;

	private int state = WAITING;

	/**
	 * Na przysz³oœæ do obs³ugi komunikatów. Aktualnie nie u¿ywane.
	 * @param theInput
	 * @return
	 */
	public String processInput(String theInput) {
		String theOutput = null;
		if (state == WAITING) {
			theOutput = "WELCOME";
			state = TRANSMISION;
		} else if (state == TRANSMISION) {
			if (theInput.equalsIgnoreCase("END")) {
				theOutput = "END";
				state = WAITING;
			} else {
				theOutput = "WORKING";
			}
		}
		return theOutput;
	}

}
