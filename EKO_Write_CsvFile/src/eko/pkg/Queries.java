package eko.pkg;

public class Queries {
	
	static String imps_Ppi_AllTr = "select count(*),sum(nt.txamount),nt.txstatus from nefttransaction nt left join ekotransaction et on nt.EkoTrxnId =et.TransactionID  "
			+ "where nt.destination=2 and nt.mode=1 and et.TypeID=81 and nt.trackingnumber is not null group by nt.txstatus;";

	static String imps_Ppi_Null = "select sum(if(nt.trackingnumber is null and nt.txstatus <>7,'1','0')) as null_response_trxn,"
			+ "sum(if(nt.trackingnumber is null and nt.txstatus <>7,nt.txamount,'0')) as null_response_trxn_vol,"
			+ "sum(if(nt.reconstatus is null,'1','0')) as timeout_trxn,sum(if(nt.reconstatus is null,txamount,'0')) as timeout_trxn_vol "
			+ "from  nefttransaction nt left join ekotransaction et on nt.EkoTrxnId =et.TransactionID "
			+ "where nt.destination=2 and nt.mode=1 and et.TypeID=81;";
	
	static String imps_Icici_AllTr ="select count(*),sum(nt.txamount),nt.txstatus from nefttransaction nt left join ekotransaction et on nt.EkoTrxnId =et.TransactionID "
			+ "where nt.destination=1 and nt.mode=1 and et.TypeID=81 and nt.trackingnumber is not null group by nt.txstatus;";
	
	static String imps_Icici_Null ="select sum(if(nt.trackingnumber is null and nt.txstatus <>7 and nt.txstatus not in (1,3,4),'1','0')) as null_response_trxn, "
			+ "sum(if(nt.trackingnumber is null and nt.txstatus <>7 and nt.txstatus not in (1,3,4),nt.txamount,'0')) as null_response_trxn_vol, "
			+ "sum(if(nt.reconstatus is null,'1','0')) as timeout_trxn, sum(if(nt.reconstatus is null,nt.txamount,'0')) as timeout_trxn_vol "
			+ "from  nefttransaction nt left join ekotransaction et on nt.EkoTrxnId =et.TransactionID "
			+ "where nt.destination=1 and nt.mode=1 and et.TypeID=81 and nt.txamount>1";
	
	
	static String neft_Icici_AllTr ="select count(*),sum(nt.txamount),nt.txstatus from nefttransaction nt left join ekotransaction et on nt.EkoTrxnId =et.TransactionID "
			+ "where nt.destination=1 and nt.mode=0 and et.TypeID=81 and nt.trackingnumber is not null group by nt.txstatus;";
	
	static String neft_Icici_Null ="select sum(if(nt.trackingnumber is null and nt.txstatus <>7,'1','0')) as null_response_trxn, "
			+ "sum(if(nt.trackingnumber is null and nt.txstatus <>7,nt.txamount,'0')) as null_response_trxn_vol, sum(if(nt.reconstatus is null,'1','0')) as timeout_trxn,"
			+ "sum(if(nt.reconstatus is null,nt.txamount,'0')) as timeout_trxn_vol from  nefttransaction nt left join ekotransaction et on nt.EkoTrxnId =et.TransactionID "
			+ "where nt.destination=1 and nt.mode=0 and et.TypeID=81";
	
	static String neft_Rbl_AllTr ="select count(*),sum(nt.txamount),nt.txstatus from  nefttransaction nt left join ekotransaction et on nt.EkoTrxnId =et.TransactionID "
			+ "where nt.destination=2 and nt.mode=0 and et.TypeID=81 and nt.trackingnumber is not null group by nt.txstatus;";
	
	static String neft_Rbl_Null ="select  sum(if(nt.trackingnumber is null and nt.txstatus <>7,'1','0')) as null_response_trxn, "
			+ "sum(if(nt.trackingnumber is null and nt.txstatus <>7,nt.txamount,'0')) as null_response_trxn_vol, sum(if(nt.reconstatus is null,'1','0')) as timeout_trxn,"
			+ "sum(if(nt.reconstatus is null,nt.txamount,'0')) as timeout_trxn_vol from  nefttransaction nt left join ekotransaction et on nt.EkoTrxnId =et.TransactionID "
			+ "where nt.destination=2 and nt.mode=0 and et.TypeID=81";
	
	static String sbi_Tkt_AllTr ="select count(*),sum(CBS_CUSTOMER_DEPOSIT_AMOUNT),TRXNSTATUS from ekoremotetrxntosbi where EKO_TRXN_ID is not null group by TRXNSTATUS;";
	
	static String sbi_Tkt_Null ="select sum(if(EKO_TRXN_ID is null and TRXNSTATUS <>2,'1','0')) as null_response_trxn, sum(if(EKO_TRXN_ID is null "
			+ "and TRXNSTATUS <>2,CBS_CUSTOMER_DEPOSIT_AMOUNT,'0')) as null_response_trxn_vol, sum(if(RECON_STATUS is null,'1','0')) as timeout_trxn,"
			+ "sum(if(RECON_STATUS is null,CBS_CUSTOMER_DEPOSIT_AMOUNT,'0')) as timeout_trxn_vol from ekoremotetrxntosbi";

}
