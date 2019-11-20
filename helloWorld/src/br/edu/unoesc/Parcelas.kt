package br.edu.unoesc

import java.time.LocalDate

class Parcelas(){

    fun getValorParcela(total: Double, qtdParcelas: Int, qtdDiasEntreParcelas: Int){

        var dataHoje = LocalDate.now()
        var valorParcela: Double = total / qtdParcelas

        for(i:Int in 1..qtdParcelas){
            var dias : Int = i*qtdDiasEntreParcelas

            println("Data da parcela: "+dataHoje.plusDays(dias.toLong()))
            println("Valor: " + valorParcela)
            println("Parcela: " + i)
        }
    }

}