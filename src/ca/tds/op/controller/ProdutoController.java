/**
 * 
 */
package ca.tds.op.controller;

import java.util.List;

import ca.tds.op.dao.DaoFactory;
import ca.tds.op.dto.ProdutoDTO;
import ca.tds.op.interfac.IProduto;
import ca.tds.op.model.Produto;

/**
 * @author Thanatos
 *
 */
public class ProdutoController 
{

	// M�todo para criar
    public static ProdutoDTO cadastrar(Produto pProduto)
    {
        if (pProduto == null)
            return new ProdutoDTO(false, "Tentativa de inserir uma Produto nulo");

        // Chamando a camada de persist�ncia
        IProduto tDao = DaoFactory.getProdutoHibernate();
        Produto tProduto = tDao.criar(pProduto);

        // Verificando se houve erro de cria��o
        if (tProduto == null)
            return new ProdutoDTO(false, "Problemas na grava��o da Produto");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ProdutoDTO(true, "Produto gravado com sucesso", tProduto);
    }

    // M�todo para recuperar
    public static ProdutoDTO recuperar(int pIdListaCompra)
    {
        // Lendo o objeto
    	IProduto tDao = DaoFactory.getProdutoHibernate();
        Produto tProduto = tDao.recuperar(pIdListaCompra);

        // Verificando se houve erro de recupera��o
        if (tProduto == null)
            return new ProdutoDTO(false, "Produto n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new ProdutoDTO(true, "Produto lido com sucesso", tProduto);
    }

    // M�todo para atualizar
    public static ProdutoDTO atualizar(Produto pProduto)
    {
        if (pProduto == null)
            return new ProdutoDTO(false, "Tentativa de atualizar com um objeto nulo");

        // Chamando a camada de persist�ncia
        IProduto tDao = DaoFactory.getProdutoHibernate();
        Produto tProduto = tDao.atualizar(pProduto);

        // Verificando se houve erro de atualiza��o
        if (tProduto == null)
            return new ProdutoDTO(false, "Produto n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new ProdutoDTO(true, "Produto regravado com sucesso", tProduto);
    }

    // M�todo para deletar
    public static ProdutoDTO remover(int pIdListaCompra)
    {
        // Removendo e verificando se houve erro de remo��o
    	IProduto tDao = DaoFactory.getProdutoHibernate();
        if (! tDao.deletar(pIdListaCompra))
            return new ProdutoDTO(false, "Produto n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new ProdutoDTO(true, "Produto removido com sucesso");
    }

    // M�todo para pesquisar 
    public static ProdutoDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	IProduto tDao = DaoFactory.getProdutoHibernate();
        List<Produto> tLista = tDao.pesquisar();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new ProdutoDTO(false, "Lista vazia");

        // Retornando a lista obtida
        return new ProdutoDTO(true, "Lista de Categorias recuperada", tLista);
    }
    

}
