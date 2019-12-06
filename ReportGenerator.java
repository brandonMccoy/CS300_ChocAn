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
		ALL, MEMBER, PROVIDER, EFT
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
			bw.write(String.format("ChocAn                                  Member Report                           %d/%d/%d  ",month,day,year));
			bw.newLine();
			bw.write("_______________________________________________________________________________________________________________");
			bw.newLine();
			bw.newLine();
			bw.write(" ID #          Member Name                Member Address              City      State       Zip    ");
			bw.newLine();
			bw.write("_______________________________________________________________________________________________________________");
			bw.newLine();
			bw.write(String.format("%d          %s                         %s                  %s     %s     %s ",report.u_id,report.u_name,report.u_address,report.u_city,report.u_state,report.u_zip));
			bw.close();

		} catch (IOException e)
		{
			e.printStackTrace();
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
			bw.write(String.format("ChocAn                                Provider Report                                      %d/%d/%d  ",month,day,year));
			bw.newLine();
			bw.write("_______________________________________________________________________________________________________________");
			bw.newLine();
			bw.newLine();
			bw.write(" ID #          Provider Name             Provider Address              City      State       Zip    ");
			bw.newLine();
			bw.write("_______________________________________________________________________________________________________________");
			bw.newLine();
			bw.write(String.format("%d          %s                         %s                  %s     %s     %s ",report.u_id,report.u_name,report.u_address,report.u_city,report.u_state,report.u_zip));

			bw.close();

		} catch (IOException e)
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

			bw.write(String.format("ChocAn                                EFT Summary                                      %d/%d/%d  ",month,day,year));
			bw.newLine();
			bw.write(" ID #          Provider Name             ");
			bw.newLine();
			bw.write(String.valueOf(report.u_id));
			bw.write("                 ");
			bw.write(report.u_name);
			bw.write("             ");
			bw.newLine();
			bw.newLine();
			bw.write(String.format("Amount to be transfered : %s",report.u_funds));
			bw.close();


	}catch(IOException e)
		{
			e.printStackTrace();
		}
		}
	}

	
