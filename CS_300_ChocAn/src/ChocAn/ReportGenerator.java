package ChocAn;

import java.io.OutputStream;

/*
 * This class methods were written based off of what I thought we probably need,
 * but it hasn't been thought out
 */

public class ReportGenerator {
	
	enum ReportType { ALL, MEMBER, PROVIDER, EFT, SUMMARY_ACCOUNTS_PAYABLE, DIRECTORY };
	
	// Output stream needs to be thought out more
	// I wasn't clear what to do with Model user arg
	public static void GenerateReport(ReportType type, OutputStream dest, IModel user)
	{
		switch (type) {
		case ALL:
			RunAllReports(dest);
			break;
		case MEMBER:
			RunMemberReports(dest);
			break;
		case PROVIDER:
			RunProviderReports(dest);
			break;
		case DIRECTORY:
			RunDirectory();
			break;
		case EFT:
			RunEFTSummary(dest);
			break;
		case SUMMARY_ACCOUNTS_PAYABLE:
			RunAccountSummary(dest);
			break;
		default:
			break;
		}
	}


	private static void RunAllReports(OutputStream dest) {
		RunMemberReports(dest);
		RunProviderReports(dest);
		RunAccountSummary(dest);
		RunEFTSummary(dest);
	}
	
	private static void RunMemberReports(OutputStream dest) {
		
	}
	
	private static void RunProviderReports(OutputStream dest) {
		
	}
	
	private static void RunAccountSummary(OutputStream dest) {
		
	}
	
	private static void RunEFTSummary(OutputStream dest) {
		
	}
	
	private static void RunDirectory() {
		System.out.println("Provider Directory sent successfully.");
	}
}
