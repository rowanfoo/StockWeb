import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.ServletException;

import access.StockAccess;
import access.TechStrAccess;
import factory.DAOFactoryStock;
import util.FormatUtil;

public class HttpImportJSP {
//	String url = "http://finance.yahoo.com/d/quotes.csv?s=ABC.AX+AGL.AX+ALL.AX+ALQ.AX&f=snohgl1vc1p2pa2m3m8m4m6";
	//String url ="";
	
String arr[]= new String[6];
ArrayList<TechStrAccess>	data = new ArrayList<TechStrAccess>	();
HashMap <String ,StockAccess> stock;
	public void init() throws Exception  {
	
		// url=myurl;
		 arr[0]="http://finance.yahoo.com/d/quotes.csv?s=ABC.AX+AGL.AX+ALL.AX+ALQ.AX+AMC.AX+AMP.AX+ANN.AX+ANZ.AX+APA.AX+AST.AX+ASX.AX+AWC.AX+AZJ.AX+BEN.AX+BHP.AX+BKL.AX+BLD.AX+BOQ.AX+BSL.AX+BXB.AX+CAR.AX+CBA.AX+CCL.AX+CGF.AX+CIM.AX+COH.AX+CPU.AX+CSL.AX+CSR.AX+CTX.AX+CWN.AX+CYB.AX+DLX.AX+DMP.AX+DOW.AX+DUE.AX+DXS.AX+FLT.AX+FMG.AX+FXJ.AX+GMG.AX+GNC.AX+GPT.AX+HGG.AX+HSO.AX+HVN.AX+IAG.AX+IFL.AX+ILU.AX+INM.AX+IOF.AX+IPL.AX+JBH.AX+JHX.AX+LLC.AX+MFG.AX+MGR.AX+MPL.AX+MQG.AX+NAB.AX+NCM.AX+NST.AX+NVT.AX+ORA.AX+ORG.AX+ORI.AX+OSH.AX+PPT.AX+PRY.AX+QAN.AX+QBE.AX+QUB.AX+REA.AX+RHC.AX+RIO.AX+RMD.AX+S32.AX+SCG.AX+SEK.AX+SGP.AX+SGR.AX+SHL.AX+SKI.AX+SRX.AX+STO.AX+SUN.AX+SYD.AX+TAH.AX+TCL.AX+TLS.AX+TPM.AX+TTS.AX+TWE.AX+VCX.AX+VOC.AX+WBC.AX+WES.AX+WFD.AX+WOW.AX+WPL.AX&f=snohgl1vc1p2pa2m3m8m4m6";
		 arr[1]="http://download.finance.yahoo.com/d/quotes.csv?s=A2M.AX+AAC.AX+AAD.AX+ABP.AX+ACX.AX+AHG.AX+AHY.AX+ALU.AX+AOG.AX+API.AX+APN.AX+APO.AX+ARB.AX+BAL.AX+BAP.AX+BGA.AX+BKW.AX+BPT.AX+BRG.AX+BTT.AX+BWP.AX+CCP.AX+CGC.AX+CHC.AX+CMW.AX+CQR.AX+CTD.AX+CWY.AX+ECX.AX+EHE.AX+EVN.AX+FBU.AX+FPH.AX+FXL.AX+GEM.AX+GMA.AX+GOZ.AX+GTY.AX+GUD.AX+GWA.AX+GXL.AX+GXY.AX+IFN.AX+IGO.AX+IPH.AX+IRE.AX+ISD.AX+IVC.AX+JHC.AX+LNK.AX+MIN.AX+MMS.AX+MND.AX+MQA.AX+MTR.AX+MTS.AX+MYO.AX+MYR.AX+MYX.AX+NEC.AX+NSR.AX+NUF.AX+NWS.AX+NXT.AX+OFX.AX+ORE.AX+OZL.AX+PGH.AX+PMV.AX+PTM.AX+REG.AX+RFG.AX+RRL.AX+RSG.AX+RWC.AX+SAI.AX+SAR.AX+SBM.AX+SCP.AX+SDF.AX+SFR.AX+SGM.AX+SIP.AX+SKC.AX+SKT.AX+SPK.AX+SPO.AX+SUL.AX+SVW.AX+SWM.AX+SXL.AX+SYR.AX+TGR.AX+TME.AX+TNE.AX+VRT.AX+WEB.AX+WHC.AX+WOR.AX+WSA.AX&f=snohgl1vc1p2pa2m3m8m4m6";
		 arr[2]="http://download.finance.yahoo.com/d/quotes.csv?s=ADH.AX+AGI.AX+AIA.AX+AJA.AX+AJX.AX+AMA.AX+AQG.AX+ARF.AX+ASB.AX+AVN.AX+AWE.AX+AYS.AX+BBN.AX+BDR.AX+BKY.AX+BLA.AX+BMN.AX+BWX.AX+CAB.AX+CCV.AX+CDD.AX+CKF.AX+CL1.AX+CNU.AX+CSV.AX+CVO.AX+CWP.AX+CXU.AX+DCN.AX+DNA.AX+DRM.AX+DYL.AX+ELD.AX+EML.AX+EPW.AX+EQT.AX+EWC.AX+FAR.AX+FET.AX+FNP.AX+FSF.AX+GBT.AX+GDI.AX+GHC.AX+GOR.AX+HFA.AX+HFR.AX+HPI.AX+HSN.AX+HUO.AX+IDR.AX+IEL.AX+IFM.AX+IMF.AX+INA.AX+IPD.AX+ISU.AX+KAR.AX+KGN.AX+KMD.AX+LNG.AX+LYC.AX+MGC.AX+MLD.AX+MLX.AX+MNS.AX+MOC.AX+MSB.AX+MVF.AX+NAN.AX+NHF.AX+NTC.AX+OGC.AX+OML.AX+PDN.AX+PEN.AX+PLS.AX+PRG.AX+PRU.AX+RCG.AX+RCR.AX+RFF.AX+RIC.AX+SDA.AX+SEH.AX+SGF.AX+SHV.AX+SIQ.AX+SIV.AX+SLK.AX+SPL.AX+SSM.AX+SXY.AX+TEN.AX+TFC.AX+TGA.AX+TIX.AX+TOE.AX+TOX.AX+TRS.AX+UEQ.AX+UGL.AX+VIT.AX+VLW.AX+VRL.AX+VTG.AX+WBA.AX+WPP.AX+WTC.AX&f=snohgl1vc1p2pa2m3m8m4m6";	
		 arr[3]="http://download.finance.yahoo.com/d/quotes.csv?s=AKP.AX+AUB.AX+AUI.AX+BKN.AX+CBL.AX+CDP.AX+CEN.AX+CIN.AX+CVW.AX+DJW.AX+DUI.AX+FLN.AX+GTN.AX+IXI.AX+LEP.AX+MEQ.AX+MFF.AX+MGE.AX+PME.AX+RVA.AX+SRV.AX+SST.AX+URF.AX+VAF.AX+WCB.AX+ZIM.AX&f=snohgl1vc1p2pa2m3m8m4m6";
		// arr[4]="http://download.finance.yahoo.com/d/quotes.csv?s=TGH.AX+SCO.AX+PSI.AX+HLO.AX+PPC.AX+OHE.AX+NCK.AX+SLF.AX+PEP.AX+VGL.AX+MIR.AX+PLG.AX+MSB.AX+ELD.AX+WBA.AX+SLK.AX+ISU.AX+HPI.AX+AJA.AX+BWX.AX+CUV.AX+WLE.AX+CSV.AX+SIV.AX+GHC.AX+FGX.AX+ALF.AX+DFM.AX+YAL.AX+IRI.AX+PPH.AX+AYS.AX+EWC.AX+ASL.AX+KMD.AX+CL1.AX+LIC.AX+RIC.AX+MPP.AX+TEN.AX+HFA.AX+SLC.AX+HFR.AX+SSM.AX+QMS.AX+MLD.AX+DDR.AX+FAN.AX+OFX.AX+PRG.AX+PMC.AX+LOV.AX+MYS.AX+CWP.AX+WHF.AX+BLX.AX+DNA.AX+NTC.AX+TOX.AX+AGG.AX+EQT.AX+MGX.AX+IXP.AX+IDR.AX+BBN.AX+HUO.AX+PSQ.AX+RFF.AX+CDM.AX+TBR.AX+ASZ.AX+HHV.AX+RCR.AX+MNF.AX+SLR.AX+UOS.AX+FAR.AX+PNI.AX+BPA.AX+VIT.AX+QIP.AX+APL.AX+SFY.AX+IMF.AX+PGF.AX+MVP.AX+FGG.AX+ALK.AX+AOF.AX+EPW.AX+ACO.AX+SXY.AX+AWE.AX+AFP.AX+MNS.AX+NEA.AX+LNG.AX+AXP.AX+PWH.AX+TGG.AX+APX.AX+PAI.AX+QVE.AX+HUB.AX+SPL.AX+RAP.AX+TGA.AX+MOC.AX+SKB.AX+VLA.AX+RMS.AX+AFG.AX+VGS.AX+WAX.AX+PHI.AX&f=snohgl1vc1p2pa2m3m8m4m6";
		 arr[4]="http://download.finance.yahoo.com/d/quotes.csv?s=TGH.AX+SCO.AX+PSI.AX+HLO.AX+PPC.AX+OHE.AX+NCK.AX+SLF.AX+PEP.AX+VGL.AX+MIR.AX+PLG.AX+CUV.AX+WLE.AX+FGX.AX+ALF.AX+DFM.AX+YAL.AX+IRI.AX+PPH.AX+ASL.AX+LIC.AX+MPP.AX+SLC.AX+QMS.AX+DDR.AX+FAN.AX+PMC.AX+LOV.AX+MYS.AX+WHF.AX+BLX.AX+AGG.AX+MGX.AX+IXP.AX+PSQ.AX+CDM.AX+TBR.AX+ASZ.AX+HHV.AX+MNF.AX+SLR.AX+UOS.AX+PNI.AX+BPA.AX+QIP.AX+APL.AX+SFY.AX+PGF.AX+MVP.AX+FGG.AX+ALK.AX+AOF.AX+ACO.AX+AFP.AX+NEA.AX+AXP.AX+PWH.AX+TGG.AX+APX.AX+PAI.AX+QVE.AX+HUB.AX+RAP.AX+SKB.AX+VLA.AX+RMS.AX+AFG.AX+VGS.AX+WAX.AX+PHI.AX&f=snohgl1vc1p2pa2m3m8m4m6";
			
		 
		 //arr[5]="http://download.finance.yahoo.com/d/quotes.csv?s=GBT.AX+CAT.AX+8IH.AX+MAQ.AX+PMP.AX+TCH.AX+VLW.AX+CII.AX+CMA.AX+ALI.AX+EDE.AX+CDA.AX+PDN.AX+SDG.AX+RHL.AX+PAY.AX+MOY.AX+BBG.AX+ADH.AX+GNG.AX+MNY.AX+CGL.AX+ONE.AX+IDX.AX+AVJ.AX+GTK.AX+PIC.AX+AMH.AX+VAS.AX+IFM.AX+DTL.AX+TIL.AX+TGP.AX+MGC.AX+AQG.AX+PEA.AX+SHJ.AX+ADA.AX+SOM.AX+ABA.AX+BLK.AX+TRS.AX+WLL.AX+SMN.AX+FRI.AX+IMD.AX+SEA.AX+SEH.AX+CLQ.AX+CVC.AX+MLB.AX+MUA.AX+NMT.AX+CDV.AX+BGL.AX+ENN.AX+IGL.AX+EMC.AX+GOW.AX+BFG.AX+PPS.AX+CTN.AX+COE.AX+RCT.AX+RBL.AX+NWH.AX+AFY.AX+RKN.AX+HOM.AX+GEG.AX+EMF.AX+CLH.AX+DCG.AX+BNO.AX+TRY.AX+OVH.AX+KSC.AX+CDU.AX+AJD.AX+AUF.AX+WTP.AX+CZZ.AX+KSL.AX+EZL.AX+PNV.AX+EGH.AX+ONT.AX+OCL.AX+TZN.AX+IBK.AX+EVO.AX+KDR.AX+TOF.AX+AGF.AX+DWS.AX+ATU.AX+WAF.AX+MTO.AX+SMR.AX+AJM.AX+MRN.AX+FSA.AX+RDV.AX+GCY.AX+88E.AX+BSE.AX+3PL.AX+AIK.AX+UPD.AX+IIL.AX+RFX.AX+MP1.AX+TPE.AX+BAF.AX+ELX.AX+TWR.AX+PNR.AX+LOM.AX+NZK.AX+GZL.AX+BSA.AX+RWH.AX+CMP.AX+UBA.AX+AHX.AX+HIL.AX+AVB.AX+PGC.AX+AJL.AX+EGS.AX+AFA.AX+RND.AX+FLK.AX+MVW.AX+MML.AX+SSG.AX+NBL.AX+SEN.AX+RHP.AX+APD.AX+ADJ.AX+OBJ.AX+GRR.AX+1AL.AX+MEA.AX+SGH.AX+BLY.AX+ZML.AX+NZM.AX+OTW.AX+RXP.AX+ITQ.AX+BCK.AX+TIG.AX+SHM.AX+CGS.AX+VGB.AX+CVN.AX+HAV.AX+YOW.AX+WIC.AX+BFC.AX+LAU.AX+USG.AX+FWD.AX+AGO.AX+CDC.AX+AQC.AX+TOP.AX+NNW.AX+TTC.AX+FND.AX+MJP.AX+SDI.AX+GAP.AX+MBE.AX+IOZ.AX+BLG.AX+XIP.AX+LHB.AX+MCP.AX+PHG.AX+AVG.AX+MXI.AX+APZ.AX+GVF.AX+TNG.AX+AGD.AX+RUL.AX+MAH.AX+OPT.AX+IAA.AX+AWN.AX+PPG.AX+TAM.AX+RAN.AX+LYL.AX+EAI.AX+S2R.AX+PRT.AX+RCB.AX+SMX.AX+ORL.AX+OSP.AX&f=snohgl1vc1p2pa2m3m8m4m6";
		 arr[5]="http://download.finance.yahoo.com/d/quotes.csv?s=CAT.AX+8IH.AX+MAQ.AX+PMP.AX+TCH.AX+CII.AX+CMA.AX+ALI.AX+EDE.AX+CDA.AX+SDG.AX+RHL.AX+PAY.AX+MOY.AX+BBG.AX+GNG.AX+MNY.AX+CGL.AX+ONE.AX+IDX.AX+AVJ.AX+GTK.AX+PIC.AX+AMH.AX+VAS.AX+DTL.AX+TIL.AX+TGP.AX+PEA.AX+SHJ.AX+ADA.AX+SOM.AX+ABA.AX+BLK.AX+WLL.AX+SMN.AX+FRI.AX+IMD.AX+SEA.AX+CLQ.AX+CVC.AX+MLB.AX+MUA.AX+NMT.AX+CDV.AX+BGL.AX+ENN.AX+IGL.AX+EMC.AX+GOW.AX+BFG.AX+PPS.AX+CTN.AX+COE.AX+RCT.AX+RBL.AX+NWH.AX+AFY.AX+RKN.AX+HOM.AX+GEG.AX+EMF.AX+CLH.AX+DCG.AX+BNO.AX+TRY.AX+OVH.AX+KSC.AX+CDU.AX+AJD.AX+AUF.AX+WTP.AX+CZZ.AX+KSL.AX+EZL.AX+PNV.AX+EGH.AX+ONT.AX+OCL.AX+TZN.AX+IBK.AX+EVO.AX+KDR.AX+TOF.AX+AGF.AX+DWS.AX+ATU.AX+WAF.AX+MTO.AX+SMR.AX+AJM.AX+MRN.AX+FSA.AX+RDV.AX+GCY.AX+88E.AX+BSE.AX+3PL.AX+AIK.AX+UPD.AX+IIL.AX+RFX.AX+MP1.AX+TPE.AX+BAF.AX+ELX.AX+TWR.AX+PNR.AX+LOM.AX+NZK.AX+GZL.AX+BSA.AX+RWH.AX+CMP.AX+UBA.AX+AHX.AX+HIL.AX+AVB.AX+PGC.AX+AJL.AX+EGS.AX+AFA.AX+RND.AX+FLK.AX+MVW.AX+MML.AX+SSG.AX+NBL.AX+SEN.AX+RHP.AX+APD.AX+ADJ.AX+OBJ.AX+GRR.AX+1AL.AX+MEA.AX+SGH.AX+BLY.AX+ZML.AX+NZM.AX+OTW.AX+RXP.AX+ITQ.AX+BCK.AX+TIG.AX+SHM.AX+CGS.AX+VGB.AX+CVN.AX+HAV.AX+YOW.AX+WIC.AX+BFC.AX+LAU.AX+USG.AX+FWD.AX+AGO.AX+CDC.AX+AQC.AX+TOP.AX+NNW.AX+TTC.AX+FND.AX+MJP.AX+SDI.AX+GAP.AX+MBE.AX+IOZ.AX+BLG.AX+XIP.AX+LHB.AX+MCP.AX+PHG.AX+AVG.AX+MXI.AX+APZ.AX+GVF.AX+TNG.AX+AGD.AX+RUL.AX+MAH.AX+OPT.AX+IAA.AX+AWN.AX+PPG.AX+TAM.AX+RAN.AX+LYL.AX+EAI.AX+S2R.AX+PRT.AX+RCB.AX+SMX.AX+ORL.AX+OSP.AX&f=snohgl1vc1p2pa2m3m8m4m6";
				
		 try(DAOFactoryStock dao = new DAOFactoryStock()) {
				
			 stock=dao.getAllStockWishList();
				
				   
					
				} catch (Exception e) {	
					System.out.println("HttpImportJS get stockwishlist :"+e); 
					throw new ServletException ("ERROR  HttpImportJSP stockwishlist :"+e);
				}
			 
	
	}
	
	
	
	private String cleanString(String data){
		//String no = data.substring(0,data.indexOf("%")   );
		String no = data.replaceAll("%", "");
		return no.replaceAll("\"" , "");
		//System.out.println("no:"+no);
		//return Double.parseDouble(no);
	
	}
	public void insert(String code,String name,	String open,String high,String low,	String close,String vol,String change,String changepercent,String previousclose,String mthAvg,String fifty,String fiftychg,	String twohd,String twohdchg)throws Exception {
      // System.out.println("insert:"+ code+	open+high+low+ close+ vol+ change+ changepercent+ previousclose+ mthAvg+ fifty+ fiftychg+ twohd+twohdchg);

		 double chgPercent = Double.parseDouble(cleanString(changepercent));
    		double myvol = Double.parseDouble(vol);
    		
    		double avgVol =FormatUtil.convertNumberFormat(mthAvg); 
    		
    		double fifty1=FormatUtil.convertNumberFormat(fifty);		
    		double fiftychg1=FormatUtil.convertNumberFormat(cleanString(fiftychg));		
    		double twohund=FormatUtil.convertNumberFormat(twohd);
    		double twohundchg=FormatUtil.convertNumberFormat(cleanString(twohdchg));
    		
    		double highh=FormatUtil.convertNumberFormat(high);
    		double lowl=FormatUtil.convertNumberFormat(low);
    		double openl=FormatUtil.convertNumberFormat(open);
 	
			double myclose=(Double.parseDouble(close));
		
			if(chgPercent <= -3){
	       		
				//System.out.println("obj is : "+chgPercent)	;	 
   					TechStrAccess tech =new  TechStrAccess(code,new Date(),9,myclose ,fifty1,fiftychg1/100,(long)myvol,avgVol,chgPercent,"","","",0,"",0,0,0);
       		 		//System.out.println("obj is : "+tech)	;	       		
       				tech.setName(name);
       				data.add(tech);
       			
   				
   				
   				
	       	}
       		if(myvol > (avgVol*1.5)   ){
       		//System.out.println("obj is : "+code+":"+myvol+" : "+ (avgVol*1.5))	;	
       			
       			TechStrAccess tech =new  TechStrAccess(code,new Date(),3,myclose ,fifty1,fiftychg1/100,(long)myvol,avgVol,chgPercent,"","","",0,"",0,0,0);
       		 		       		
       				tech.setName(name);
       				data.add(tech);
       				
       			
       		
       			
       			
       		}
       		if(stock.containsKey(code)){
       			
       			StockAccess st=stock.get(code);
       			double price = st.getWhenBuyPrice();
       			if(price*1.05 <= myclose  ){
       				
       					
       				TechStrAccess tech =new  TechStrAccess(code,new Date(),16,myclose ,0,0,0,0,0,"","","",0,"",price,0,0);
	 		       		
       				tech.setName(name);
       				data.add(tech);
       				
       				
       			}
       		
       		
       		}
			
			
		
	
	
	}	

	public void importData() throws Exception {
		int count = 0;
		String code = "";
		String name="";
		String open = "";
		String high = "";
		String low = "";
		String close = "";
		String vol = "";
		String change = "";
		String changepercent = "";
		String previousclose = "";
		String mthAvg = "";
		String fifty = "";
		String fiftychg = "";
		String twohd = "";
		String twohdchg = "";
		
		StringBuffer response = new StringBuffer();
		int index=0;
		for (String url : arr) {
			URL obj = new URL(url);
			System.out.println("Sending Index : "+index+":" );

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : "+index+":" + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				StringTokenizer st = new StringTokenizer(inputLine, ",");
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					// System.out.println("count :"+count);
					// System.out.println("token :"+token);
					switch (count) {
					case 0:
						code = cleanString(token);
						// System.out.println("code :"+code);
						break;
					case 1:
						name= token;
						break;
					case 2:
						open = token;
						break;
					case 3:
						high = token;
						break;
					case 4:
						low = token;
						break;
					case 5:
						close = token;
						break;
					case 6:
						vol = token;
						break;
					case 7:
						change = token;
						break;
					case 8:
						changepercent = token;
						break;
					case 9:
						previousclose = token;
						break;
					case 10:
						mthAvg = token;
						break;
					case 11:
						fifty = token;
						break;
					case 12:
						fiftychg = token;
						break;
					case 13:
						twohd = token;
						break;
					case 14:
						twohdchg = token;
						count = -1;
						insert(code, name,open, high, low, close, vol, change, changepercent, previousclose, mthAvg, fifty,
								fiftychg, twohd, twohdchg);
						
						
						
						break;

					// case 15: System.out.println("here :"); count=-1;
					// insert( code, open, high, low, close, vol, change,
					// changepercent, previousclose, mthAvg, fifty, fiftychg,
					// twohd,
					// twohdchg);
					// break;

					}
					count = count + 1;
					// System.out.println("Mycode:"+code);
					// System.out.println("twohdchg:"+twohdchg);
				}
			}
			System.out.println("FINISH   INDEX: "+index );
			index++;
			in.close();
			Thread.sleep(10000);
			
		}
		// print result
		// System.out.println(response.toString());

	}

	public ArrayList<TechStrAccess>  run()throws Exception {
		try {
			
			init();
			System.out.println("Init Done : ");


			 importData();
				System.out.println("Import Data done : ");
				
				Collections.sort(data, new Comparator<TechStrAccess>() {
			        @Override
			        public int compare(TechStrAccess fr2, TechStrAccess fr1)
			        {

			            return (int) (fr2.getMode() - fr1.getMode());

			        }
			    });
			
	 
				
				
				return data;

		} catch (Exception e) {
			System.out.println("Error run : " + e);
			 throw new Exception(e);
		}
	}

	public static void main(String[] args){
		HttpImportJSP ht=null;
		
		ht=new HttpImportJSP();
		
		try {
			ht.run();
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		
		

	
	}









}
