package com.snowball.patsupport.utils;

import com.snowball.patsupport.bean.NewSqRequest;

/**
 * 查询订单状态
 */
public class QueryOrderStatus {

    private static final String QUERY_ORDER_STATUS = "/order/query";

    public static void main(String[] args) {
        String[] cardNoAndBizNos = new String[]{
//                "4790057347012198010081910492309471874810000000510000047429EB834B80010000000000535244,6222002392020082817580372869192,3104870494122576770",
//                "479007644701F35606000068102919400621481000000051000004333E35901E80020000000000354552,6222002392020082817580372869189,3104870494122576112",
//                "479007644701F356060093120546024002784810000000510000043047A5E51D80010000000000354552,6222002392020082817580372869187,3104870494122572134",
//                "479005734701219801008191113399947187481000000051000004202923864B80010000000000535244,6222002392020082817580372869185,3104870494122569930",
//                "479007644701F356060093090960424002684810000000510000045E36B5E11D80010000000000354552,6222002392020082817580372869184,3104870494122568472",
//                "47900573470121980100819118417694718948100000005100000463138B8A4B80010000000000535244,6222002392020090214580372869170,3104870494122563279",
//                "479005734701219801007159000558941845481000000051000004210C3BAD4180010000000000535244,6222002392020090214580372869166,3104870494122561172",
//                "479007644701F3560600931907622640030548100000005100000408268DF61D80010000000000354552,6222002392020082817580372869174,3104870494122554846",
//                "479005734701219801007085000116941048481000000051000004300553594080010000000000535244,6222002392020090214580372869196,3104870494122554233",
//                "47900573470121980100819118417694718948100000005100000463138B8A4B80010000000000535244,6222002392020090214580372869168,3104870494122551731",
//                "479007644701F35606000088090407400679481000000051000004353BC5A81E80020000000000354552,6222002392020082817580372869191,3104870494122550453",
//                "479007644701F356060090841100793002814810000000510000043E4DD3175280010000000000354552,6222002392020082817580372869175,3104870494122365738",
//                "479007644701F356060000501228094005614810000000510000042B09DD741E80020000000000354552,6222475592020082620120450149738,3104870494122363677",
//                "479005734701219801007085000116941048481000000051000004300553594080010000000000535244,6222002392020090214580372869199,3104870494122340681",
//                "479007644701F35606000030047497400508481000000051000004513B254F1E80020000000000354552,6222002392020082817580372869179,3104870494122324977",
//                "479005734701219801007085000116941048481000000051000004300553594080010000000000535244,6222002392020090214580372869201,3104870494122324094",
//                "479005734701219801007085000116941048481000000051000004300553594080010000000000535244,6222002392020090214580372869195,3104870494122289940",
//                "479007644701F356060093261400824003184810000000510000042C43DDFC1D80010000000000354552,6222002392020090214580372869202,3104870494122274810",
//                "479007644701F35606009128079321300769481000000051000004194A7BB95280010000000000354552,6222475592020082716480245913783,3104870494122257387",
//                "479007644701F356060083520132049491264810000000510000044313C3AD4F80010000000000354552,6222002392020082817580372869204,3104870494122247649",
//                "479005734701219801007085000116941048481000000051000004300553594080010000000000535244,6222002392020090214580372869198,3104870494122246749",
//                "479007644701F356060000451359954005434810000000510000042716AD681E80020000000000354552,6222002392020082817580372869173,3104870494122246118",
//                "479007644701F356060090670805133000904810000000510000044212FBC35180010000000000354552,6222002392020082817580372869172,3104870494122235192",
//                "479007644701F356060090530375179498934810000000510000041C10137E5180010000000000354552,6222002392020090214580372869178,3104870494122226525",
//                "479007644701F35606009330145871400325481000000051000004403FBDFE1D80010000000000354552,6222002392020082817580372869171,3104870494122222592",
//                "479005734701219801007290196269944104481000000051000004262DA3514580010000000000535244,6222002392020082817580372869190,3104870494122219604",
//                "479005734701219801007085000116941048481000000051000004300553594080010000000000535244,6222002392020090214580372869194,3104870494122212214",
//                "479007644701F356060093290325064003244810000000510000045C1EA5FD1D80010000000000354552,6222002392020082817580372869188,3104870494122195052",
//                "479007644701F356060093320305924003374810000000510000042850F5001E80010000000000354552,6222002392020082817580372869201,3104870494122179159",
//                "479005734701219801007085000116941048481000000051000004300553594080010000000000535244,6222002392020090214580372869197,3104870494122172624",
//                "479007644701F35606000043135351400535481000000051000004420EA5631E80020000000000354552,6222475592020082520430430269103,3104870494122167080",
//                "4790057347012198010072031918459424564810000000510000043D59438E4280010000000000535244,6222002392020082817580372869186,3104870494122162238",
//                "4790057347012198010072891047699440684810000000510000046D2E3B4F4580010000000000535244,6222002392020082817580372869167,3104870494122161022",
//                "479005734701219801007085000116941048481000000051000004300553594080010000000000535244,6222002392020090214580372869193,3104870494122131845",
//                "479007644701F35606000003084192400444481000000051000004363AF5331E80020000000000354552,6222002392020090214580372869176,3104870494122122890",
//                "479007644701F356060000031328164004444810000000510000044C36D5341E80020000000000354552,6222475592020082716260558758681,3104870494122079745",
//                "479007644701F35606009354056973400396481000000051000004251DD51A1E80010000000000354552,6222475592020082618080050832820,3104870494122068873",
//                "479005734701219801008119195964946568481000000051000004652B8B654A80010000000000535244,6222002392020082817580372869183,3104870494122037390",
//                "47900573470121980100714305766594170748100000005100000410225B864180010000000000535244,6222002392020082817580372869181,3104870494122020235"
        };
        //{"merchantCode":"80000004","data":"{\"orderNo\":\"62724755032020090217164169348252\",\"currentStep\":\"BOF\",\"actionType\":0,\"cplc\":\"47900573470121980100715100433194177048100000005100000454303B9341800100000000004D5055\",\"persoPayMoney\":0,\"persoDestMoney\":0,\"topupPayMoney\":0,\"topupDestMoney\":0}","timestamp":"1599040022917","sign":"c918f4e896b5a8feeb03e21cbe1d3003"}
        String[] datas = new String[cardNoAndBizNos.length];
        for (int i = 0; i < cardNoAndBizNos.length; i++) {
            String data = JsonUtil.toJson(NewSqRequest.NewSqRequestForQueryOrderStatus(cardNoAndBizNos[i].split(",")), false);
            datas[i] = data;
        }
        CommonSpRequestUtil.exec(datas,QueryOrderStatus.QUERY_ORDER_STATUS);
    }

}
