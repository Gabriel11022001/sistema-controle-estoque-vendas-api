package br.com.gabriel.sistemacontroleestoquevendas.utils;

public interface IConverteDTOEmEntidade<D, E> {

    E converter(D dto);
}
