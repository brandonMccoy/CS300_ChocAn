package ChocAn;

import java.io.*;


import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.File;


/*
 * This class methods were written based off of what I thought we probably need,
 * but it hasn't been thought out
 */

public class ReportGenerator
{
	int u_id;
	String u_name;
	String u_address;
	String u_city;
	String u_state;
	String u_zip;
	String u_funds;

	//get the file paths for the database and output files
	//_________________________________________________________

	File Memberfile = new File("CS_300_ChocAn/MemberReport.txt");
	String Memberdest = Memberfile.getAbsolutePath();

	File Providerfile = new File("CS_300_ChocAn/ProviderReport.txt");
	String Providerdest = Providerfile.getAbsolutePath();

	File EFTfile = new File("CS_300_ChocAn/EFT_report");
	String EFTdest = EFTfile.getAbsolutePath();

	File Member_database = new File("CS_300_ChocAn/memberDB.csv");
	String member_path = Member_database.getAbsolutePath();

	File Provider_database = new File("CS_300_ChocAn/providerDB.csv");
	String provider_path = Provider_database.getAbsolutePath();


	File EFT_database = new File("CS_300_ChocAn/EFTDB.csv");
	String EFT_path = EFT_database.getAbsolutePath();
   //_______________________________________________________________________________

	enum ReportType
	{
		ALL, MEMBER, PROVIDER, ACCOUNT_PAYABLE,EFT
	}

	;

	// Output stream needs to be thought out more
	// I wasn't clear what to do with Model user arg
	public static void GenerateReport(ReportType type, int id) throws IOException
	{
		ReportGenerator report = new ReportGenerator();

		switch (type)
		{
			case ALL:
				RunAllReports(id);
				break;
			case MEMBER:
				try
				{
					RunMemberReports(id);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				break;
			case PROVIDER:
				try
				{
					RunProviderReports(id);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				break;
			case ACCOUNT_PAYABLE:
                try
                {
                    RunAccountSummary(id);
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
			case EFT:
				try
				{
					RunEFTSummary(id);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				break;
			default:
				break;
		}
	}


	private static void RunAllReports(int id) throws IOException
	{

		RunMemberReports(id);
		RunProviderReports(id);
		RunEFTSummary(id);

	}

	private static void RunMemberReports(int id) throws IOException
	{

		ReportGenerator report = new ReportGenerator();
		String row = null;
		BufferedReader csvReader = new BufferedReader(new FileReader(report.member_path));
		while ((row = csvReader.readLine()) != null)
		{
			Scanner scanner = new Scanner(row);
			scanner.useDelimiter(",");
			String data = scanner.next();


			if ((Integer.parseInt(String.valueOf(data)) == id))
			{
				report.u_id = Integer.parseInt(data);
				System.out.println(report.u_id);
				int i = 0;

				while (scanner.hasNext())
				{
					data = scanner.next();

					if (i == 0)
					{
						report.u_name = data;
					} else if (i == 1)
					{
						report.u_address = data;
					} else if (i == 2)
					{
						report.u_city = data;
					} else if (i == 3)
					{
						report.u_zip = data;
					}

					++i;

				}
				System.out.println(report.u_name);
				System.out.println(report.u_address);
				System.out.println(report.u_city);
				System.out.println(report.u_zip);

			}


		}
		if(report.u_id != id)
		{
			System.out.println(String.format("Member with ID: %d could not be found", id));
		}
		else
		{
			try
			{
				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year = cal.get(Calendar.YEAR);

				File file = new File(report.Memberdest);

				if (!file.exists())
					file.createNewFile();

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(String.format("ChocAn                                  Member Report                           %d/%d/%d  ", month, day, year));
				bw.newLine();
				bw.write("_______________________________________________________________________________________________________________");
				bw.newLine();
				bw.newLine();
				bw.write(" ID #          Member Name                Member Address              City      State       Zip    ");
				bw.newLine();
				bw.write("_______________________________________________________________________________________________________________");
				bw.newLine();
				bw.write(String.format("%d          %s                         %s                  %s     %s     %s ", report.u_id, report.u_name, report.u_address, report.u_city, report.u_state, report.u_zip));
				bw.close();

			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}


	}


	private static void RunProviderReports(int id) throws IOException
	{

		ReportGenerator report = new ReportGenerator();

		String row = null;
		BufferedReader csvReader = new BufferedReader(new FileReader(report.provider_path));
		while ((row = csvReader.readLine()) != null)
		{
			Scanner scanner = new Scanner(row);
			scanner.useDelimiter(",");
			String data = scanner.next();


			if ((Integer.parseInt(String.valueOf(data)) == id))
			{
				report.u_id = Integer.parseInt(data);
				System.out.println(report.u_id);
				int i = 0;

				while (scanner.hasNext())
				{
					data = scanner.next();

					if (i == 0)
					{
						report.u_name = data;
					} else if (i == 1)
					{
						report.u_address = data;
					} else if (i == 2)
					{
						report.u_city = data;
					} else if (i == 3)
					{
						report.u_state= data;
					}
					else if(i==4)
					{
						report.u_zip = data;
					}

					++i;

				}

			}

		}
		if(report.u_id != id)
		{
			System.out.println(String.format("Member with ID: %d could not be found", id));
		}
		else
		{

			try
			{


				File file = new File(report.Providerdest);

				if (!file.exists())
					file.createNewFile();

				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year = cal.get(Calendar.YEAR);

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(String.format("ChocAn                                Provider Report                                      %d/%d/%d  ", month, day, year));
				bw.newLine();
				bw.write("_______________________________________________________________________________________________________________");
				bw.newLine();
				bw.newLine();
				bw.write(" ID #          Provider Name             Provider Address              City      State       Zip    ");
				bw.newLine();
				bw.write("_______________________________________________________________________________________________________________");
				bw.newLine();
				bw.write(String.format("%d          %s                         %s                  %s     %s     %s ", report.u_id, report.u_name, report.u_address, report.u_city, report.u_state, report.u_zip));

				bw.close();

			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}


	}

	private static void RunAccountSummary(int id) throws IOException
	{

		Database database = new Database();
		ReportGenerator report = new ReportGenerator();
		String consultation_ar[] = new String[1000000];
		String consultation_number[] = new String [1000000];
		for(int i =0; i< database.consultationDB.size();++i)
		{
			for(int j = 0; j<database.consultationDB.size();++j)
			{
				consultation_ar[(Integer.parseInt(String.valueOf(database.consultationDB.get(i).providerNumber)))] += String.valueOf(database.consultationDB.get(j).fee))

				consultation_number[(Integer.parseInt(String.valueOf(database.consultationDB.get(i).providerNumber)))] +=1;


			}

		}
		int num_of_providers= 0;
		for(int k = 0; k<100000;++k)
		{
			if(Integer.parseInt(String.valueOf(consultation_number[(Integer.parseInt(String.valueOf(database.consultationDB.get(k).providerNumber)))]))>0)
			{
				++num_of_providers;

			}
		}



			try
            {

                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int year = cal.get(Calendar.YEAR);

                File file = new File(report.EFTdest);

                if (!file.exists())
                    file.createNewFile();

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(String.format("ChocAn                                Account Summary                                      %d/%d/%d  ",month,day,year));
                bw.newLine();
                bw.write(" ID #          Amount Owed             ");
                bw.newLine();
                for(int i = 0; i< database.consultationDB.size();++i)
				{
                bw.write(String.format("%s              %s",String.valueOf(database.consultationDB.get(i).memberNumber),consultation_ar[(Integer.parseInt(String.valueOf(database.consultationDB.get(i).providerNumber)))]));

				}

				bw.newLine();
                bw.write(String.format("# of providers = %d",num_of_providers);
                bw.newLine();
                bw.write(String.format("# of consultations = %d",database.consultationDB.size()));


            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }



	private static void RunEFTSummary(int id) throws IOException
	{
		ReportGenerator report = new ReportGenerator();
		String row = null;
		BufferedReader csvReader = new BufferedReader(new FileReader(report.EFT_path));
		while ((row = csvReader.readLine()) != null)
		{
			Scanner scanner = new Scanner(row);
			scanner.useDelimiter(",");
			String data = scanner.next();


			if ((Integer.parseInt(String.valueOf(data)) == id))
			{
				report.u_id = Integer.parseInt(data);
				System.out.println(report.u_id);
				int i = 0;

				while (scanner.hasNext())
				{
					data = scanner.next();

					if (i == 0)
					{
						report.u_name = data;
					} else if (i == 1)
					{
						report.u_funds = data;
					}

					++i;

				}

			}

		}

		if (report.u_id != id)
		{
			System.out.println(String.format("Member with ID: %d could not be found", id));
		} else
		{

			try
			{

				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year = cal.get(Calendar.YEAR);

				File file = new File(report.EFTdest);

				if (!file.exists())
					file.createNewFile();

				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(String.format("ChocAn                                EFT Summary                                      %d/%d/%d  ", month, day, year));
				bw.newLine();
				bw.write(" ID #          Provider Name             ");
				bw.newLine();
				bw.write(String.valueOf(report.u_id));
				bw.write("                 ");
				bw.write(report.u_name);
				bw.write("             ");
				bw.newLine();
				bw.newLine();
				bw.write(String.format("Amount to be transfered : %s", report.u_funds));
				bw.close();


			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
