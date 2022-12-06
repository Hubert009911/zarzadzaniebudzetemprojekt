# -- admin -admin
# -- user -user

INSERT INTO `pf_user` (`id`, `login`, `password`, `first_name`, `email`, `phone`, `last_login`, `enabled`, `role`, `created_at`, `changed_by`, `changed_at`) VALUES
  (1, 'admin', '$2a$04$Q9tr5kvxzeQ.0xgdEDLruuJp76FU/pVs6gKOggMmCSYPPMAPcYGY2', 'admin', 'test@mail.com', NULL, NULL, 1, 'ADMIN', '2012-10-29 02:34:32', 1, '2012-10-29 02:34:32'),
  (2, 'user', '$2a$04$NwOEvYbGJvPJkz5C/HnmG.lxnk6X/3p0PGziwXUI95wHcj4qcBFE2', 'user', 'test1@mail.com', NULL, NULL, 1, 'USER', '2012-10-29 02:34:32', 1, '2012-10-29 02:34:32');

INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XUA','ADB Unit of Account','XUA');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('AFN','Afghan Afghani','؋');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ALL','Albanian Lek','L');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('DZD','Algerian Dinar','دج');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ADP','Andorran Peseta','ADP');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('AOA','Angolan Kwanza','Kz');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ARS','Argentine Peso','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('AMD','Armenian Dram','֏');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('AWG','Aruban Florin','ƒ');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('AUD','Australian Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ATS','Austrian Schilling','ATS');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('AYM','AYM','AYM');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('AZN','Azerbaijani Manat','₼');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BSD','Bahamian Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BHD','Bahraini Dinar','.د.ب');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BDT','Bangladeshi Taka','৳');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BBD','Barbadian Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BYR','Belarusian Ruble','p.');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BEF','Belgian Franc','BEF');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BZD','Belize Dollar','BZ$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BMD','Bermudan Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BTN','Bhutanese Ngultrum','Nu.');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BOB','Bolivian Boliviano','Bs.');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BOV','Bolivian Mvdol','BOV');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BWP','Botswanan Pula','P');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BRL','Brazilian Real','R$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GBP','British Pound Sterling','£');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BND','Brunei Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BGL','Bulgarian Hard Lev','BGL');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BGN','Bulgarian Lev','лв');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('BIF','Burundian Franc','FBu');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('KHR','Cambodian Riel','៛');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CAD','Canadian Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CVE','Cape Verdean Escudo','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('KYD','Cayman Islands Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XOF','CFA Franc BCEAO','CFA');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XAF','CFA Franc BEAC','FCFA');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CLP','Chilean Peso','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CLF','Chilean Unit of Account (UF)','CLF');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CNY','Chinese Yuan','¥');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('COP','Colombian Peso','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('KMF','Comorian Franc','CF');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CDF','Congolese Franc','FC');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CRC','Costa Rican Colón','₡');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('HRK','Croatian Kuna','kn');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CUC','Cuban Convertible Peso','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CUP','Cuban Peso','₱');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CYP','Cypriot Pound','CYP');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CZK','Czech Republic Koruna','Kč');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('DKK','Danish Krone','kr');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('DJF','Djiboutian Franc','Fdj');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('DOP','Dominican Peso','RD$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('NLG','Dutch Guilder','NLG');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XCD','East Caribbean Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('EGP','Egyptian Pound','£');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ERN','Eritrean Nakfa','Nfk');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('EEK','Estonian Kroon','kr');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ETB','Ethiopian Birr','Br');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('EUR','Euro','€');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('FKP','Falkland Islands Pound','£');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('FJD','Fijian Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('FIM','Finnish Markka','FIM');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('FRF','French Franc','FRF');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XFO','French Gold Franc','XFO');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XFU','French UIC-Franc','XFU');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GMD','Gambian Dalasi','D');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GEL','Georgian Lari','₾');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('DEM','German Mark','DEM');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GHS','Ghanaian Cedi','GH₵');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GIP','Gibraltar Pound','£');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XAU','Gold','XAU');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GRD','Greek Drachma','GRD');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GTQ','Guatemalan Quetzal','Q');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GWP','Guinea-Bissau Peso','GWP');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GNF','Guinean Franc','FG');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('GYD','Guyanaese Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('HTG','Haitian Gourde','G');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('HNL','Honduran Lempira','L');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('HKD','Hong Kong Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('HUF','Hungarian Forint','Ft');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ISK','Icelandic Króna','kr');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('INR','Indian Rupee','₹');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('IDR','Indonesian Rupiah','Rp');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('IRR','Iranian Rial','﷼');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('IQD','Iraqi Dinar','ع.د');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('IEP','Irish Pound','IEP');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ILS','Israeli New Sheqel','₪');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ITL','Italian Lira','ITL');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('JMD','Jamaican Dollar','J$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('JPY','Japanese Yen','¥');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('JOD','Jordanian Dinar','JOD');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('KZT','Kazakhstani Tenge','₸');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('KES','Kenyan Shilling','KSh');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('KWD','Kuwaiti Dinar','KWD');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('KGS','Kyrgystani Som','лв');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('LAK','Laotian Kip','₭');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('LVL','Latvian Lats','Ls');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('LBP','Lebanese Pound','£');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('LSL','Lesotho Loti','M');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('LRD','Liberian Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('LYD','Libyan Dinar','LYD');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('LTL','Lithuanian Litas','Lt');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('LUF','Luxembourgian Franc','LUF');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MOP','Macanese Pataca','MOP$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MKD','Macedonian Denar','ден');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MGA','Malagasy Ariary','Ar');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MGF','Malagasy Franc','MGF');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MWK','Malawian Kwacha','MK');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MYR','Malaysian Ringgit','RM');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MVR','Maldivian Rufiyaa','Rf');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MTL','Maltese Lira','MTL');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MRO','Mauritanian Ouguiya','MRO');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MUR','Mauritian Rupee','₨');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MXV','Mexican Investment Unit','MXV');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MXN','Mexican Peso','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MDL','Moldovan Leu','lei');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MNT','Mongolian Tugrik','₮');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MAD','Moroccan Dirham','MAD');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MZN','Mozambican Metical','MT');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('MMK','Myanma Kyat','K');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('NAD','Namibian Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('NPR','Nepalese Rupee','₨');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ANG','Netherlands Antillean Guilder','ƒ');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('TWD','New Taiwan Dollar','NT$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('NZD','New Zealand Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('NIO','Nicaraguan Córdoba','C$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('NGN','Nigerian Naira','₦');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('KPW','North Korean Won','₩');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('NOK','Norwegian Krone','kr');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('OMR','Omani Rial','﷼');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('PKR','Pakistani Rupee','₨');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XPD','Palladium','XPD');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('PAB','Panamanian Balboa','B/.');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('PGK','Papua New Guinean Kina','K');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('PYG','Paraguayan Guarani','Gs');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('PEN','Peruvian Nuevo Sol','S/.');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('PHP','Philippine Peso','₱');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XPT','Platinum','XPT');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('PLN','Polish Zloty','zł');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('PTE','Portuguese Escudo','PTE');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('QAR','Qatari Rial','﷼');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('RON','Romanian Leu','lei');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('RUB','Russian Ruble','₽');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('RWF','Rwandan Franc','R₣');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SHP','Saint Helena Pound','£');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SVC','Salvadoran Colón','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('WST','Samoan Tala','WS$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('STD','São Tomé and Príncipe Dobra','Db');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SAR','Saudi Riyal','﷼');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('RSD','Serbian Dinar','Дин.');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SCR','Seychellois Rupee','₨');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SLL','Sierra Leonean Leone','Le');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XAG','Silver','XAG');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SGD','Singapore Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SKK','Slovak Koruna','SKK');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SIT','Slovenian Tolar','SIT');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SBD','Solomon Islands Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SOS','Somali Shilling','S');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ZAR','South African Rand','R');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('KRW','South Korean Won','₩');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SSP','South Sudanese Pound','£');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ESP','Spanish Peseta','ESP');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XDR','Special Drawing Rights','XDR');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('LKR','Sri Lankan Rupee','₨');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XSU','Sucre','XSU');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SDG','Sudanese Pound','ج.س.');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SRD','Surinamese Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SRG','Surinamese Guilder','SRG');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SZL','Swazi Lilangeni','E');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SEK','Swedish Krona','kr');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('CHF','Swiss Franc','Fr.');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('SYP','Syrian Pound','£');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('TJS','Tajikistani Somoni','SM');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('TZS','Tanzanian Shilling','TSh');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('XTS','Testing Currency Code','XTS');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('THB','Thai Baht','฿');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('TPE','Timorese Escudo','TPE');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('TOP','Tongan Paʻanga','T$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('TTD','Trinidad and Tobago Dollar','TT$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('TND','Tunisian Dinar','د.ت');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('TRY','Turkish Lira','₺');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('TMT','Turkmenistani Manat','T');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('UGX','Ugandan Shilling','USh');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('UAH','Ukrainian Hryvnia','₴');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('AED','United Arab Emirates Dirham','د.إ');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('UYU','Uruguayan Peso','$U');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('USD','US Dollar','$');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('UYI','UYI','UYI');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('UZS','Uzbekistan Som','лв');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('VUV','Vanuatu Vatu','VT');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('VEF','Venezuelan Bolívar','Bs');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('VND','Vietnamese Dong','₫');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('YER','Yemeni Rial','﷼');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ZMK','Zambian Kwacha','ZMK');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ZWL','Zimbabwean Dollar (2009)','ZWL');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ZMW','ZMW','ZMW');
INSERT INTO `currency` (`iso_code`,`name`,`symbol`) VALUES ('ZWN','ZWN','ZWN');