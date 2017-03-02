package automationFramework;

public class TestSuite {

	public static void main(String[] args) throws InterruptedException {
		TC1_SendMessageToAll.main();
		//TC2 is commented because it didn't work: I wasn't able to find a way to select an item from the recipients list.
		//TC2_SendMessageToOne.main();
		TC3_UploadCorrectFileJpg.main();
		TC4_UploadCorrectFilePng.main();
		TC5_SendWithEmptyBody.main();
		TC6_SendWithEmptySubj.main();
		TC7_UploadWrongExtFile.main();
		TC8_UploadTooLargeFilePng.main();
	}
}
