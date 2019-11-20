package br.edu.unoesc

import java.time.LocalDate

class Cancelamento constructor(
   val cliente_id: Long,
   val usuario_responsavel_id: Long,
   val data_cadatro: LocalDate,
   val classificacao_cliente: String,
   val quantidade_usuario_pagantes: Long,
   val data_inicio: LocalDate,
   val data_cancelamento: LocalDate,
   val motivo_cancelamento_id: Long,
   val motivo: String) {

    override fun toString(): String {
        return "Cancelamento(cliente_id=$cliente_id, usuario_responsavel_id=$usuario_responsavel_id, data_cadatro='$data_cadatro', classificacao_cliente='$classificacao_cliente', quantidade_usuario_pagantes=$quantidade_usuario_pagantes, data_inicio='$data_inicio', data_cancelamento='$data_cancelamento', motivo_cancelamento_id=$motivo_cancelamento_id, motivo='$motivo')"
    }


    // descomentar e comentar cada companion object para executar
    //    1 - Número de cancelamentos por classificação do cliente, ordenado pelo maior número DESC
    companion object {
        fun getNumeroDeCancelamentosPorClassificacao(cancelamentos: List<Cancelamento>) {
            val totalCancelamento = cancelamentos.groupBy { it.classificacao_cliente }
            totalCancelamento.toList().sortedByDescending { (key, value) -> value.size }.toMap().forEach {
                print(it.value.size)
                print(" - ")
                println(it.value.get(0).classificacao_cliente)
            }
        }


//    2 - Média de tempo de vida(dias entre início e cancelamento)
    var cont = 0
    var dias = 0
        fun getMediaVida(cancelamentos: List<Cancelamento>) {
            val diaInicio = cancelamentos.groupBy { it.data_inicio }
            val diaFim = cancelamentos.groupBy { it.data_cancelamento }
            print(diaInicio)
            print(" - ")
            println(diaFim)
        }


//    3 - Número de cancelamentos por motivo de cancelamento, ordenado pelo maior número DESC
        fun getNumeroDeCancelamentosPorMotivo(cancelamentos: List<Cancelamento>) {
            val totalCancelamento = cancelamentos.groupBy { it.motivo_cancelamento_id }
                totalCancelamento.toList().sortedByDescending { (key, value) -> value.size }.toMap().forEach {
                    print(it.value.size)
                    print(" - motivo "+it.value.get(0).motivo_cancelamento_id)
                    println(" "+it.value.get(0).motivo)
                }
        }

//    4 - Quantidade de usuários cancelados por mês/ano, ordenado pelo mes/ano ASC
        fun getQuantidadeUsuariosCanceladosPorMes(cancelamentos: List<Cancelamento>){

        }

//    5 - Quantidade de clientes cancelados por usuário responsável, ordenado por número DESC
        fun getQuantidadeCanceladosPorUsuario(cancelamentos: List<Cancelamento>) {
            val quantidade = cancelamentos.groupBy { it.usuario_responsavel_id }
                quantidade.toList().sortedByDescending { (key, value) -> value.size }.toMap().forEach {
                    print(it.value.size)
                    print(" - Responsavel: ")
                    println(it.value.get(0).usuario_responsavel_id)
                }
        }
    }
}