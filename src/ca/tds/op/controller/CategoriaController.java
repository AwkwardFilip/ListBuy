package ca.tds.op.controller;

import java.util.List;

import ca.tds.op.dao.DaoFactory;
import ca.tds.op.dto.CategoriaDTO;
import ca.tds.op.interfac.ICategoria;
import ca.tds.op.model.Categoria;

/**
 * @author Thanatos
 *
 */
public class CategoriaController 
{
	// M�todo para criar
    public static CategoriaDTO cadastrar(Categoria pCategoria)
    {
    	
        if (pCategoria == null)
            return new CategoriaDTO(false, "Tentativa de inserir uma Categoria nulo");

        // Chamando a camada de persist�ncia
        ICategoria tDao = DaoFactory.getCategoriaHibernate();
        Categoria tCategoria = tDao.criar(pCategoria);

        // Verificando se houve erro de cria��o
        if (tCategoria == null)
            return new CategoriaDTO(false, "Problemas na grava��o da Categoria");

        // Retornando o indicativo de sucesso com o objeto criado
        return new CategoriaDTO(true, "Categoria gravado com sucesso", tCategoria);
    }

    // M�todo para recuperar
    public static CategoriaDTO recuperar(int pIdCategoria)
    {
        // Lendo o objeto
    	ICategoria tDao = DaoFactory.getCategoriaHibernate();
        Categoria tCategoria = tDao.recuperar(pIdCategoria);

        // Verificando se houve erro de recupera��o
        if (tCategoria == null)
            return new CategoriaDTO(false, "Categoria n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new CategoriaDTO(true, "Categoria lido com sucesso", tCategoria);
    }

    // M�todo para atualizar
    public static CategoriaDTO atualizar(Categoria pCategoria)
    {
        if (pCategoria == null)
            return new CategoriaDTO(false, "Tentativa de atualizar com um objeto nulo");

        // Chamando a camada de persist�ncia
        ICategoria tDao = DaoFactory.getCategoriaHibernate();
        Categoria tCategoria = tDao.atualizar(pCategoria);

        // Verificando se houve erro de atualiza��o
        if (tCategoria == null)
            return new CategoriaDTO(false, "Categoria n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new CategoriaDTO(true, "Categoria regravado com sucesso", tCategoria);
    }

    // M�todo para deletar
    public static CategoriaDTO remover(int pIdCategoria)
    {
        // Removendo e verificando se houve erro de remo��o
    	ICategoria tDao = DaoFactory.getCategoriaHibernate();
        if (! tDao.deletar(pIdCategoria))
            return new CategoriaDTO(false, "Categoria n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new CategoriaDTO(true, "Categoria removido com sucesso");
    }

    // M�todo para pesquisar 
    public static CategoriaDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	ICategoria tDao = DaoFactory.getCategoriaHibernate();
        List<Categoria> tLista = tDao.pesquisar();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new CategoriaDTO(false, "Lista vazia");

        // Retornando a lista obtida
        return new CategoriaDTO(true, "Lista de Categorias recuperada", tLista);
    }

    // M�todo para pesquisar por nome
    public static CategoriaDTO pesquisarPorNome(String pNome)
    {
        // Caso o nome de pesquisa seja nulo, retorna a lista geral
        if (pNome == null)
            return pesquisar();

        // Obtendo a lista
        ICategoria tDao = DaoFactory.getCategoriaHibernate();
        List<Categoria> tLista = tDao.pesquisarNome(pNome);

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new CategoriaDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

        // Retornando a lista obtida
        return new CategoriaDTO(true, "Lista de Categoria recuperada", tLista);
    }
    

}
