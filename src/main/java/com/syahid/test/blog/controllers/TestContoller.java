package com.syahid.test.blog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@RestController
@RequestMapping("/test")
@SecurityScheme(
	    name = "bearerAuth",
	    type = SecuritySchemeType.HTTP,
	    bearerFormat = "JWT",
	    scheme = "bearer"
	)
public class TestContoller {
	
	//testtop
	
//    @Autowired
//    private ValueOperations<String, Object> redisOps;
//	
//	@GetMapping("/test-redis")
//	@SecurityRequirements(value = {@SecurityRequirement(name = "bearerAuth")})
//	public Object testRedis(@RequestParam String param) {
//		Object test = redisOps.get(param);
//		System.out.println(test);
//		return test;
//	}
	
//	@GetMapping("/set-redis")
//	@SecurityRequirements(value = {@SecurityRequirement(name = "bearerAuth")})
//	public String setRedis() {
//		String stringRedis = "\\xac\\xed\\x00\\x05sr\\x00Tid.co.ist.digitalbanking.esbservicecommon.payment.base.dto.PaymentTransactionDataDto\\xb5F\\x866!\\xeaw\\t\\x02\\x00\\x01L\\x00\\x15paymentAdditionalDatat\\x00ULid/co/ist/digitalbanking/esbservicecommon/payment/base/dto/PaymentAdditionalDataDto;xr\\x00Did.co.ist.digitalbanking.esbservicecommon.dto.BaseTransactionDataDto\\xfc\\x19\\xa9W\\xf5k\\xa6\\xd1\\x02\\x00@L\\x00\\x0caccountAliast\\x00\\x12Ljava/lang/String;L\\x00\\x12accountProductNameq\\x00~\\x00\\x03L\\x00\\x0fadditionalData1q\\x00~\\x00\\x03L\\x00\\x0fadditionalData2q\\x00~\\x00\\x03L\\x00\\x0fadditionalData3q\\x00~\\x00\\x03L\\x00\\x11beneficiaryNumberq\\x00~\\x00\\x03L\\x00\\x14beneficiaryOwnerNameq\\x00~\\x00\\x03L\\x00\\x0bbillFlagMapq\\x00~\\x00\\x03L\\x00\\bbillInfot\\x00\\x0fLjava/util/Map;L\\x00\\bbillKey1q\\x00~\\x00\\x03L\\x00\\bbillKey2q\\x00~\\x00\\x03L\\x00\\bbillKey3q\\x00~\\x00\\x03L\\x00\\x0bbillReceiptq\\x00~\\x00\\x04L\\x00\\x0bbillerImageq\\x00~\\x00\\x03L\\x00\\nbillerNameq\\x00~\\x00\\x03L\\x00\\nbranchCodeq\\x00~\\x00\\x03L\\x00\\x0bchannelCodet\\x009Lco/id/ist/digitalbanking/apicommon/constant/ChannelCode;L\\x00\\x0fchannelDeviceIdq\\x00~\\x00\\x03L\\x00\\x0cchannelRefNoq\\x00~\\x00\\x03L\\x00\\x10commissionAmountt\\x00\\x16Ljava/math/BigDecimal;L\\x00\\tcoreRefNoq\\x00~\\x00\\x03L\\x00\\bdeviceIdq\\x00~\\x00\\x03L\\x00\\besbRefNoq\\x00~\\x00\\x03L\\x00\\textraDataq\\x00~\\x00\\x04L\\x00\\x13fromAccountCurrencyt\\x00ALco/id/ist/digitalbanking/apicommon/constant/TransactionCurrency;L\\x00\\x11fromAccountNumberq\\x00~\\x00\\x03L\\x00\\x14fromAccountOwnerNameq\\x00~\\x00\\x03L\\x00\\x0ffromAccountTypeq\\x00~\\x00\\x03L\\x00\\x0cfromBankCodeq\\x00~\\x00\\x03L\\x00\\x0cfromBankNameq\\x00~\\x00\\x03L\\x00\\x0cmessageRefNoq\\x00~\\x00\\x03L\\x00\\tpayeeCodeq\\x00~\\x00\\x03L\\x00\\x06remarkq\\x00~\\x00\\x03L\\x00\\nresultCodeq\\x00~\\x00\\x03L\\x00\\rresultMessageq\\x00~\\x00\\x03L\\x00\\x03rrnq\\x00~\\x00\\x03L\\x00\\bterminalq\\x00~\\x00\\x03L\\x00\\x11toAccountCurrencyq\\x00~\\x00\\aL\\x00\\x0ftoAccountNumberq\\x00~\\x00\\x03L\\x00\\x12toAccountOwnerNameq\\x00~\\x00\\x03L\\x00\\rtoAccountTypeq\\x00~\\x00\\x03L\\x00\\ntoBankCodeq\\x00~\\x00\\x03L\\x00\\ntoBankNameq\\x00~\\x00\\x03L\\x00\\x0btraceNumberq\\x00~\\x00\\x03L\\x00\\x11transactionAmountq\\x00~\\x00\\x06L\\x00\\x16transactionAmountEqualq\\x00~\\x00\\x06L\\x00\\x13transactionCategoryt\\x00ALco/id/ist/digitalbanking/apicommon/constant/TransactionCategory;L\\x00\\x0ftransactionCodeq\\x00~\\x00\\x03L\\x00\\x13transactionCurrencyq\\x00~\\x00\\aL\\x00\\x0ftransactionDatet\\x00\\x10Ljava/util/Date;L\\x00\\x16transactionDescriptionq\\x00~\\x00\\x03L\\x00\\x17transactionExchangeRateq\\x00~\\x00\\x06L\\x00\\x0etransactionFeeq\\x00~\\x00\\x06L\\x00\\x10transactionGroupt\\x00>Lco/id/ist/digitalbanking/apicommon/constant/TransactionGroup;L\\x00\\rtransactionIdq\\x00~\\x00\\x03L\\x00\\x10transactionStatet\\x00>Lco/id/ist/digitalbanking/apicommon/constant/TransactionState;L\\x00\\x11transactionStatust\\x00?Lco/id/ist/digitalbanking/apicommon/constant/TransactionStatus;L\\x00\\x16transactionTotalAmountq\\x00~\\x00\\x06L\\x00\\x0etransferOptiont\\x00GLid/co/ist/digitalbanking/esbservicecommon/constant/TransferOptionEnum;L\\x00\\aubpHostq\\x00~\\x00\\x03L\\x00\\x0cuserFullNameq\\x00~\\x00\\x03L\\x00\\x0fuserPhoneNumberq\\x00~\\x00\\x03L\\x00\\ruserProfileIdt\\x00\\x10Ljava/lang/Long;L\\x00\\x0buserSegmentq\\x00~\\x00\\x03xpt\\x00\\x17Tabungan Haji Indonesiapppppt\\x00\\x16PELANGGAN ISAT26321959psr\\x00\\x11java.util.HashMap\\x05\\a\\xda\\xc1\\xc3\\x16`\\xd1\\x03\\x00\\x02F\\x00\\nloadFactorI\\x00\\tthresholdxp?@\\x00\\x00\\x00\\x00\\x00\\x0cw\\b\\x00\\x00\\x00\\x10\\x00\\x00\\x00\\x03t\\x00\\tMobile Not\\x00\\r0856012345600t\\x00\\aNominalt\\x00\\tRp 25,000t\\x00\\x04Namet\\x00\\x16PELANGGAN ISAT26321959xt\\x00\\r0856012345600t\\x00\\x0b12073178769t\\x00\\x00pt\\x00Ihttp://10.0.116.118:9000/bsi/assets/icon%20biller/postpaid/indosat/2x.pngt\\x00\\x13Indosat Pasca Bayarp~r\\x007co.id.ist.digitalbanking.apicommon.constant.ChannelCode\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x12\\x00\\x00xr\\x00\\x0ejava.lang.Enum\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x12\\x00\\x00xpt\\x00\\x0eMOBILE_BANKINGt\\x00\\x16ezKQwz5GQtyildEgae12TLpppppsr\\x00\\x17java.util.LinkedHashMap4\\xc0N\\\\\\x10l\\xc0\\xfb\\x02\\x00\\x01Z\\x00\\x0baccessOrderxq\\x00~\\x00\\x12?@\\x00\\x00\\x00\\x00\\x00\\x0cw\\b\\x00\\x00\\x00\\x10\\x00\\x00\\x00\\x05t\\x00\\rpaymentAmountt\\x00\\x0c000000025000t\\x00\\x0bpaymentNameq\\x00~\\x00\\x11t\\x00\\adueDateq\\x00~\\x00\\x1ct\\x00\\x06regiont\\x00\\x0200t\\x00\\treferenceq\\x00~\\x00\\x1bx\\x00pt\\x00\\n7244490958t\\x00\\x0eEFRICA CAHYANIt\\x00\\x02SAt\\x00\\x03451ppt\\x00\\x040152pppt\\x00\\x0c030000369082t\\x00\\r6281269683745pq\\x00~\\x00\\x1apt\\x00\\x0bPASCA_BAYARpppsr\\x00\\x14java.math.BigDecimalT\\xc7\\x15W\\xf9\\x81(O\\x03\\x00\\x02I\\x00\\x05scaleL\\x00\\x06intValt\\x00\\x16Ljava/math/BigInteger;xr\\x00\\x10java.lang.Number\\x86\\xac\\x95\\x1d\\x0b\\x94\\xe0\\x8b\\x02\\x00\\x00xp\\x00\\x00\\x00\\x00sr\\x00\\x14java.math.BigInteger\\x8c\\xfc\\x9f\\x1f\\xa9;\\xfb\\x1d\\x03\\x00\\x06I\\x00\\bbitCountI\\x00\\tbitLengthI\\x00\\x13firstNonzeroByteNumI\\x00\\x0clowestSetBitI\\x00\\x06signum[\\x00\\tmagnitudet\\x00\\x02[Bxq\\x00~\\x007\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xfe\\xff\\xff\\xff\\xfe\\x00\\x00\\x00\\x01ur\\x00\\x02[B\\xac\\xf3\\x17\\xf8\\x06\\bT\\xe0\\x02\\x00\\x00xp\\x00\\x00\\x00\\x02a\\xa8xxp~r\\x00?co.id.ist.digitalbanking.apicommon.constant.TransactionCategory\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x12\\x00\\x00xq\\x00~\\x00 t\\x00\\x11BILLPAYMENT_PHONEp~r\\x00?co.id.ist.digitalbanking.apicommon.constant.TransactionCurrency\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x12\\x00\\x00xq\\x00~\\x00 t\\x00\\x03IDRsr\\x00\\x0ejava.util.Datehj\\x81\\x01KYt\\x19\\x03\\x00\\x00xpw\\b\\x00\\x00\\x01\\x8a\\xa6\\xf5\\x04\\x82xq\\x00~\\x00\\x1esq\\x00~\\x005\\x00\\x00\\x00\\x00sq\\x00~\\x009\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xfe\\xff\\xff\\xff\\xfe\\x00\\x00\\x00\\x01uq\\x00~\\x00<\\x00\\x00\\x00\\x01\\x01xxsq\\x00~\\x005\\x00\\x00\\x00\\x00sq\\x00~\\x009\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xff\\xfe\\xff\\xff\\xff\\xfe\\x00\\x00\\x00\\x00uq\\x00~\\x00<\\x00\\x00\\x00\\x00xx~r\\x00<co.id.ist.digitalbanking.apicommon.constant.TransactionGroup\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x12\\x00\\x00xq\\x00~\\x00 t\\x00\\x0bBILLPAYMENTp~r\\x00<co.id.ist.digitalbanking.apicommon.constant.TransactionState\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x12\\x00\\x00xq\\x00~\\x00 t\\x00\\aINQUIRY~r\\x00=co.id.ist.digitalbanking.apicommon.constant.TransactionStatus\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x12\\x00\\x00xq\\x00~\\x00 t\\x00\\x06FAILEDp~r\\x00Eid.co.ist.digitalbanking.esbservicecommon.constant.TransferOptionEnum\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x12\\x00\\x00xq\\x00~\\x00 t\\x00\\x03NOWt\\x00\\x02SVt\\x00\\x0eEfrica Cahyaniq\\x00~\\x003sr\\x00\\x0ejava.lang.Long;\\x8b\\xe4\\x90\\xcc\\x8f#\\xdf\\x02\\x00\\x01J\\x00\\x05valuexq\\x00~\\x007\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x82psr\\x00Sid.co.ist.digitalbanking.esbservicecommon.payment.base.dto.PaymentAdditionalDataDto*&\\xafA\\xf9\\x9d\\xd7\\x8e\\x02\\x00\\xa5Z\\x00\\x0cflagFavoriteL\\x00\\x0caccountIndext\\x00\\x13Ljava/lang/Integer;L\\x00\\aaddressq\\x00~\\x00\\x03L\\x00\\x0banimalPriceq\\x00~\\x00\\x03L\\x00\\nanimalTypeq\\x00~\\x00\\x03L\\x00\\x16animalWeightEstimationq\\x00~\\x00\\x03L\\x00\\rbankShortNameq\\x00~\\x00\\x03L\\x00\\tberatEmasq\\x00~\\x00\\x03L\\x00\\nbillAmountq\\x00~\\x00\\x06L\\x00\\nbill_info1q\\x00~\\x00\\x03L\\x00\\x0bbill_info10q\\x00~\\x00\\x03L\\x00\\x0bbill_info11q\\x00~\\x00\\x03L\\x00\\x0bbill_info12q\\x00~\\x00\\x03L\\x00\\x0bbill_info13q\\x00~\\x00\\x03L\\x00\\x0bbill_info14q\\x00~\\x00\\x03L\\x00\\x0bbill_info15q\\x00~\\x00\\x03L\\x00\\x0bbill_info16q\\x00~\\x00\\x03L\\x00\\x0bbill_info17q\\x00~\\x00\\x03L\\x00\\x0bbill_info18q\\x00~\\x00\\x03L\\x00\\x0bbill_info19q\\x00~\\x00\\x03L\\x00\\nbill_info2q\\x00~\\x00\\x03L\\x00\\x0bbill_info20q\\x00~\\x00\\x03L\\x00\\nbill_info3q\\x00~\\x00\\x03L\\x00\\nbill_info4q\\x00~\\x00\\x03L\\x00\\nbill_info5q\\x00~\\x00\\x03L\\x00\\nbill_info6q\\x00~\\x00\\x03L\\x00\\nbill_info7q\\x00~\\x00\\x03L\\x00\\nbill_info8q\\x00~\\x00\\x03L\\x00\\nbill_info9q\\x00~\\x00\\x03L\\x00\\x0bbookingCodeq\\x00~\\x00\\x03L\\x00\\nbranchCodeq\\x00~\\x00\\x03L\\x00\\nbranchNameq\\x00~\\x00\\x03L\\x00\\x02ccq\\x00~\\x00\\x03L\\x00\\x03cifq\\x00~\\x00\\x03L\\x00\\x03ctrq\\x00~\\x00\\x03L\\x00\\bdendaPKBq\\x00~\\x00\\x06L\\x00\\tdendaPNBPq\\x00~\\x00\\x06L\\x00\\x0cdendaSWDKLLJq\\x00~\\x00\\x06L\\x00\\tdenomCodeq\\x00~\\x00\\x03L\\x00\\tdenomNameq\\x00~\\x00\\x03L\\x00\\x0bdetailIuranq\\x00~\\x00\\x03L\\x00\\bdistrictq\\x00~\\x00\\x03L\\x00\\adueDateq\\x00~\\x00\\x03L\\x00\\x11effectiveDateFromq\\x00~\\x00\\x03L\\x00\\x0feffectiveDateToq\\x00~\\x00\\x03L\\x00\\x05emailq\\x00~\\x00\\x03L\\x00\\x0bemailFooterq\\x00~\\x00\\x03L\\x00\\x0cemailFooter2q\\x00~\\x00\\x03L\\x00\\bendStandq\\x00~\\x00\\x03L\\x00\\nexpiryDateq\\x00~\\x00\\x03L\\x00\\textraDataq\\x00~\\x00\\x04L\\x00\\rfinancingTypeq\\x00~\\x00\\x03L\\x00\\x0ffitrahInTheNameq\\x00~\\x00\\x03L\\x00\\x04flagq\\x00~\\x00\\x03L\\x00\\x10fromAccountAliasq\\x00~\\x00\\x03L\\x00\\x10hargaBeliPerGramq\\x00~\\x00\\x06L\\x00\\x10hargaJualPerGramq\\x00~\\x00\\x06L\\x00\\bidClientq\\x00~\\x00\\x03L\\x00\\x0bidTransaksiq\\x00~\\x00\\x03L\\x00\\tinTheNameq\\x00~\\x00\\x03L\\x00\\x11installmentAmountq\\x00~\\x00\\x03L\\x00\\risOpenPaymentt\\x00\\x13Ljava/lang/Boolean;L\\x00\\risQuickAccessq\\x00~\\x00^L\\x00\\x0bisReInquiryq\\x00~\\x00^L\\x00\\njenisModelq\\x00~\\x00\\x03L\\x00\\njmlAnggotaq\\x00~\\x00\\x03L\\x00\\x0bjumlahIuranq\\x00~\\x00\\x03L\\x00\\x0fjumlahTunggakanq\\x00~\\x00\\x03L\\x00\\x12jumlahTypeKepinganq\\x00~\\x00\\x03L\\x00\\tkodeIuranq\\x00~\\x00\\x03L\\x00\\blanguageq\\x00~\\x00\\x03L\\x00\\bldNumberq\\x00~\\x00\\x03L\\x00\\rlistTunggakant\\x00\\x10Ljava/util/List;L\\x00\\x0clocationNameq\\x00~\\x00\\x03L\\x00\\rlocationValueq\\x00~\\x00\\x03L\\x00\\x10mealPortionPriceq\\x00~\\x00\\x03L\\x00\\bmerkTipeq\\x00~\\x00\\x03L\\x00\\nminPaymentq\\x00~\\x00\\x03L\\x00\\tmonthYearq\\x00~\\x00\\x03L\\x00\\x12monthlyInstallmentq\\x00~\\x00\\x06L\\x00\\ampnTypeq\\x00~\\x00\\x03L\\x00\\bnextDateq\\x00~\\x00\\x03L\\x00\\x03nikq\\x00~\\x00\\x03L\\x00\\tnoInvoiceq\\x00~\\x00\\x03L\\x00\\bnoPolisiq\\x00~\\x00\\x03L\\x00\\bnoRangkaq\\x00~\\x00\\x03L\\x00\\x0enoRekeningEmasq\\x00~\\x00\\x03L\\x00\\tnpwpImageq\\x00~\\x00\\x03L\\x00\\nnpwpNumberq\\x00~\\x00\\x03L\\x00\\x04ntpdq\\x00~\\x00\\x03L\\x00\\rnumberOfSoulsq\\x00~\\x00\\x03L\\x00\\x11ongkosCetakSatuanq\\x00~\\x00\\x06L\\x00\\x10ongkosCetakTotalq\\x00~\\x00\\x06L\\x00\\x0bopeningDateq\\x00~\\x00\\x03L\\x00\\aorderIdq\\x00~\\x00\\x03L\\x00\\townerYearq\\x00~\\x00\\x03L\\x00\\tpaidUjrahq\\x00~\\x00\\x06L\\x00\\x06parkirq\\x00~\\x00\\x06L\\x00\\x0bpaymentDateq\\x00~\\x00\\x03L\\x00\\x06periodq\\x00~\\x00\\x03L\\x00\\bpokokPKBq\\x00~\\x00\\x06L\\x00\\tpokokPNBPq\\x00~\\x00\\x06L\\x00\\x0cpokokSWDKLLJq\\x00~\\x00\\x06L\\x00\\tpphAmountq\\x00~\\x00\\x06L\\x00\\rpphPercentageq\\x00~\\x00\\x03L\\x00\\tppjAmountq\\x00~\\x00\\x03L\\x00\\tppnAmountq\\x00~\\x00\\x03L\\x00\\x0bprogramNameq\\x00~\\x00\\x03L\\x00\\tpromoCodeq\\x00~\\x00\\x03L\\x00\\x10quickAccessTokenq\\x00~\\x00\\x03L\\x00\\x0fqurbanInTheNameq\\x00~\\x00\\x03L\\x00\\x0breceiptDataq\\x00~\\x00\\x04L\\x00\\x0creceiptEmailq\\x00~\\x00\\x03L\\x00\\x0breceiptNameq\\x00~\\x00\\x03L\\x00\\x0breceiptNoHpq\\x00~\\x00\\x03L\\x00\\arefCodeq\\x00~\\x00\\x03L\\x00\\x10registrationDateq\\x00~\\x00\\x03L\\x00\\x14remainingOutstandingq\\x00~\\x00\\x06L\\x00\\x0eremainingUjrahq\\x00~\\x00\\x06L\\x00\\x0ereservedField1q\\x00~\\x00\\x03L\\x00\\x0ereservedField2q\\x00~\\x00\\x03L\\x00\\x0ereservedField3q\\x00~\\x00\\x03L\\x00\\x0ereservedField4q\\x00~\\x00\\x03L\\x00\\x0ereservedField5q\\x00~\\x00\\x03L\\x00\\x18retrievalReferenceNumberq\\x00~\\x00\\x03L\\x00\\x04rodaq\\x00~\\x00\\x03L\\x00\\x0bscheduleDtot\\x00ILid/co/ist/digitalbanking/esbservicecommon/transfer/base/dto/ScheduleDto;L\\x00\\x0esettlementDateq\\x00~\\x00\\x03L\\x00\\nsklpNumberq\\x00~\\x00\\x03L\\x00\\x0bstampAmountq\\x00~\\x00\\x03L\\x00\\x04stanq\\x00~\\x00\\x03L\\x00\\nstartStandq\\x00~\\x00\\x03L\\x00\\rstatementDateq\\x00~\\x00\\x03L\\x00\\x0bstatusPolisq\\x00~\\x00\\x03L\\x00\\x11stroomTokenAmountq\\x00~\\x00\\x03L\\x00\\x10tanggalAkhirSTNKq\\x00~\\x00\\x03L\\x00\\ttarifDayaq\\x00~\\x00\\x03L\\x00\\x05tbpkbq\\x00~\\x00\\x03L\\x00\\x05tenorq\\x00~\\x00\\x03L\\x00\\x0btertanggungq\\x00~\\x00\\x03L\\x00\\x0etoAccountAliasq\\x00~\\x00\\x03L\\x00\\x05tokenq\\x00~\\x00\\x03L\\x00\\x0btotalAnimalq\\x00~\\x00\\x03L\\x00\\btotalKwhq\\x00~\\x00\\x03L\\x00\\x12totalLembarTagihanq\\x00~\\x00\\x03L\\x00\\x0ftotalPengirimanq\\x00~\\x00\\x06L\\x00\\ntotalSeatsq\\x00~\\x00\\x03L\\x00\\ntotalUjrahq\\x00~\\x00\\x06L\\x00\\x13trainCustomerNumberq\\x00~\\x00\\x03L\\x00\\ttrainNameq\\x00~\\x00\\x03L\\x00\\ntrainRouteq\\x00~\\x00\\x03L\\x00\\x0ftrainSeatNumberq\\x00~\\x00\\x03L\\x00\\ttrainTimeq\\x00~\\x00\\x03L\\x00\\x0ftransactionTypeq\\x00~\\x00\\x03L\\x00\\x05trxIdq\\x00~\\x00\\x03L\\x00\\atrxTypeq\\x00~\\x00\\x03L\\x00\\x11typeGramOrNominalq\\x00~\\x00\\x03L\\x00\\x0ctypeKepinganq\\x00~\\x00\\x03L\\x00\\x0busageVolumeq\\x00~\\x00\\x03L\\x00\\x0evirtualAccountq\\x00~\\x00\\x03L\\x00\\x10virtualAccountKKq\\x00~\\x00\\x03L\\x00\\x0bvoucherCodeq\\x00~\\x00\\x03L\\x00\\x05warnaq\\x00~\\x00\\x03L\\x00\\rzakatTypeCodeq\\x00~\\x00\\x03L\\x00\\x0ezakatTypeValueq\\x00~\\x00\\x03xp\\x00ppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppsr\\x00\\x11java.lang.Boolean\\xcd r\\x80\\xd5\\x9c\\xfa\\xee\\x02\\x00\\x01Z\\x00\\x05valuexp\\x00q\\x00~\\x00cq\\x00~\\x00cppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp";
//		redisOps.set("transaction:999", stringRedis);
//		return "testRedis";
//	}
	
	@PostMapping("/builder-to-setter/{nameVariable}")
	@SecurityRequirements(value = {@SecurityRequirement(name = "bearerAuth")})
	public String builderToSetterCtrl(@RequestBody String builder, @PathVariable String nameVariable) {
		return builderToSetter(builder, nameVariable);
	}
	
	private String builderToSetter(String builder, String nameVariable) {
		List<String> builders = builderToSetterList(builder, nameVariable);
		StringBuilder sb = new StringBuilder();
		for (String row: builders) {
			sb.append(row);
			sb.append("\r\n");
		}
		return sb.toString();
	}

	private List<String> builderToSetterList(String builder, String nameVariable) {
		String[] builders = builder.split("\\)\\.|\\)\\s+\\.");
		List<String> builderList = new ArrayList<>();
		for (int inde = 0; inde < builders.length; inde++) {
			if (builders[inde].contains("return")) continue;
			if (builders[inde].contains("builder()")) continue;
			if (builders[inde].contains("build()")) continue;
			if (builders[inde].contains("(true")) builders[inde] = builders[inde].substring(0, 2).equals("is") ? builders[inde].substring(2) : builders[inde];
			if (builders[inde].contains("(false")) builders[inde] = builders[inde].substring(0, 2).equals("is") ? builders[inde].substring(2) : builders[inde];
			builderList.add(nameVariable + ".set" + builders[inde].substring(0, 1).toUpperCase() + builders[inde].substring(1) + ");");
		}
		return builderList;
	}
	
	public static class BuilderToSetter{
		
		public String builder;
		public String nameVariable;
	}
	
	//testbottom
}
