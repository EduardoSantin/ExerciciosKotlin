package br.edu.unoesc

import java.io.File
import java.io.InputStream
import java.sql.Date

fun main(args: Array<String>){

//    println("helo world")
//    val s1 =  Superficie(altura = 3.0, largura = 4.0)
//    print(calcular(arrayOf(s1)))

    //calculador de parcelas
//    val p2 = Parcelas()
//    println("Parcelas: "+ p2.getValorParcela(total = 1000.0, qtdParcelas = 3, qtdDiasEntreParcelas = 30 ))


    // exercicio cancelamento
    val arquivo: InputStream = File("C:\\Users\\eduar\\Desktop\\cancelamentos.csv").inputStream();
    val linhas = mutableListOf<Cancelamento>()
    arquivo.bufferedReader().useLines { l-> l.forEach { val linha: String  = it.replace("\"", "")
        linhas.add(
        Cancelamento(
            cliente_id = linha.split(',')[0].toLong(),
            usuario_responsavel_id = linha.split(',')[1].toLong(),
            data_cadatro = Date.valueOf(linha.split(',')[2]).toLocalDate(),
            classificacao_cliente = linha.split(',')[3].toString(),
            quantidade_usuario_pagantes = linha.split(',')[4].toLong(),
            data_inicio = Date.valueOf(linha.split(',')[5]).toLocalDate(),
            data_cancelamento = Date.valueOf(linha.split(',')[6]).toLocalDate(),
            motivo_cancelamento_id = linha.split(',')[7].toLong(),
            motivo = linha.split(',')[8].toString()
        ))} }


    // descomentar aki e as function no Cancelamento.kt por causa do companion object
//    1 - Número de cancelamentos por classificação do cliente, ordenado pelo maior número DESC
    Cancelamento.getNumeroDeCancelamentosPorClassificacao(linhas)

//    2 - Média de tempo de vida(dias entre início e cancelamento)
//    Cancelamento.getMediaVida(linhas)

//    3 - Número de cancelamentos por motivo de cancelamento, ordenado pelo maior número DESC
//    Cancelamento.getNumeroDeCancelamentosPorMotivo(linhas)

//    4 - Quantidade de usuários cancelados por mês/ano, ordenado pelo mes/ano ASC
//        Cancelamento.getQuantidadeUsuariosCanceladosPorMes(linhas)

//    5 - Quantidade de clientes cancelados por usuário responsável, ordenado por número DESC
//        Cancelamento.getQuantidadeCanceladosPorUsuario(linhas)
}