package br.com.gabriel.sistemacontroleestoquevendas.utils;

public interface IConverteEntidadeEmDTO<T, D> {

    D converter(T entidade);
}
