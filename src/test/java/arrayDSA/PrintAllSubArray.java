package test.java.arrayDSA;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class PrintAllSubArray {

    public static  void subarraysPrinterFunction(int [] arr){
        int len = arr.length;

        for(int start=0; start<len; start++){

            for(int end = start; end<len; end++){

                System.out.print("[");

                for(int k=start; k<=end; k++){

                    System.out.print(arr[k]+" ");
                    if(k<end){
                        System.out.print(",");
                    }
                }
                System.out.print("]");
            }
       System.out.println();
        }


    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,-9};
        subarraysPrinterFunction(arr);
    }

}
