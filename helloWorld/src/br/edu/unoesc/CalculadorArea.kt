package br.edu.unoesc

    fun calcular(superficies: Array<Superficie>): Double{
        return superficies.map(Superficie::getArea).sum()
    }
