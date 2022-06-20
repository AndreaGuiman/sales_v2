package com.gad.sales_v2.client;

import java.util.List;

public class ClientConfig {
    public static void createAndSaveClients(ClientRepository clientRepository){
        clientRepository.saveAll(List.of(
                new Client(
                        "CENTRUL DE DIAGNOSTIC SRL",
                        "28472340",
                        "BCR",
                        "RO12BTRL12CRT81",
                        "provita.diagnostic@yahoo.com",
                        "0268275447",
                        true,
                        "Bucuresti"

                ),
                new Client(
                        "DYNAMIC MEDICAL SRL",
                        "10188831",
                        "Banca Transilvania",
                        "RO31BTRL123456",
                        "dynamic_medical@yahoo.com",
                        "0368123659",
                        true,
                        "Brasov"
                ),
                new Client(
                        "CENTRUL DE RECUPERARE MEDICALA TARRA",
                        "22199912",
                        "BRD",
                        "RO12BTRLRONCRT",
                        "recuperare_tarra@yahoo.com",
                        "0736875468",
                        true,
                        "Cluj"
                ),
                new Client(
                        "ALPHA MEDICAL SRL",
                        "33846988",
                        "BRD",
                        "RO12RNCB1111111111111111",
                        "aplha.medial@yahoo.com",
                        "0756341532",
                        true,
                        "Sibiu"
                ),
                new Client(
                        "VITAPLUS MEDCLIN SRL",
                        "33532195",
                        "Banca Transilvania",
                        "RO123124RTCAS",
                        "medclin_vitaplus@yahoo.com",
                        "0724123564",
                        true,
                        "Iasi"
                ),
                new Client(
                        "INMEDICAL SRL",
                        "32635605",
                        "BRD",
                        "RO123124RTCAS",
                        "inmedical@yahoo.com",
                        "0268543761",
                        true,
                        "Timisoara"
                ),
                new Client(
                        "NEOKLINIK SRL",
                        "28893762",
                        "BCR",
                        "RO123124RTCAS",
                        "neoklinink@yahoo.com",
                        "0368763123",
                        true,
                        "Brasov"
                ),
                new Client(
                        "DUO BEST MED SRL",
                        "37092852",
                        "Banca Transilvania",
                        "RO66OTPV270001083223RO01",
                        "duobest_med@yahoo.com",
                        "02845563587",
                        true,
                        "Bucuresti"
                ),
                new Client(
                        "POLIMED DACIA SRL",
                        "30956200",
                        "BCR",
                        "RO123124RTCAS",
                        "dacia.polimed@yahoo.com",
                        "0724976581",
                        true,
                        "Ilfov"
                ),
                new Client(
                        "ANTIAGE CARE SRL",
                        "33254730",
                        "BCR",
                        "RO12RNCB00882277330019",
                        "antiage.care@yahoo.com",
                        "0724976581",
                        true,
                        "Ilfov"
                ),
                new Client(
                        "TERAPIA - TIM SRL",
                        "27446634",
                        "BCR",
                        "RO22RNCB778899223344",
                        "terapia-tim@yahoo.com",
                        "0724328965",
                        true,
                        "Timisoara"
                ),
                new Client(
                        "HEALTHTIM SRL",
                        "RO26593793",
                        "BCR",
                        "RO22RNCB778899223344",
                        "healthtim@yahoo.com",
                        "0726789163",
                        true,
                        "Timisoara"
                ),
                new Client(
                        "EMIVITA SRL",
                        "16023400",
                        "Banca Transilvania",
                        "RO08BTRLRONCRT0001991",
                        "emivita@yahoo.com",
                        "0744358581",
                        true,
                        "Brasov"
                ),
                new Client(
                        "EDALMED LINE SRL",
                        "RO33890223",
                        "Raiffeisen Bank",
                        "RO43RZBR0000999907652341",
                        "edalmed-line@yahoo.com",
                        "0786232876",
                        true,
                        "Craiova"
                ),
                new Client(
                        "PRO-VITAM SRL",
                        "13747092",
                        "BCR",
                        "RO14RNCB0000999967540001",
                        "pro.vitam@yahoo.com",
                        "0724976581",
                        true,
                        "Timisoara"
                ),
                new Client(
                        "HERMA MED SRL",
                        "17079328",
                        "BCR",
                        "RO123124RTCAS",
                        "herma_med@yahoo.com",
                        "0268453714",
                        true,
                        "Sibiu"
                )
        ));
    }
}
