/**
 * 
 */
package ca.tds.op.controller;

import java.util.List;

import ca.tds.op.dao.DaoFactory;
import ca.tds.op.dto.ItemDTO;
import ca.tds.op.interfac.IItem;
import ca.tds.op.model.Item;

/**
 * @author Thanatos
 *
 */
public class ItemController 
{

	// M�todo para criar
    public static ItemDTO cadastrar(Item pItem)
    {
        if (pItem == null)
            return new ItemDTO(false, "Tentativa de inserir uma Item nulo");

        // Chamando a camada de persist�ncia
        IItem tDao = DaoFactory.getItemHibernate();
        Item tItem = tDao.criar(pItem);

        // Verificando se houve erro de cria��o
        if (tItem == null)
            return new ItemDTO(false, "Problemas na grava��o da Item");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ItemDTO(true, "Item gravado com sucesso", tItem);
    }

    // M�todo para recuperar
    public static ItemDTO recuperar(int pIdCategoria)
    {
        // Lendo o objeto
    	IItem tDao = DaoFactory.getItemHibernate();
        Item tItem = tDao.recuperar(pIdCategoria);

        // Verificando se houve erro de recupera��o
        if (tItem == null)
            return new ItemDTO(false, "Item n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new ItemDTO(true, "Item lido com sucesso", tItem);
    }

    // M�todo para atualizar
    public static ItemDTO atualizar(Item pItem)
    {
        if (pItem == null)
            return new ItemDTO(false, "Tentativa de atualizar com um objeto nulo");

        // Chamando a camada de persist�ncia
        IItem tDao = DaoFactory.getItemHibernate();
        Item tItem = tDao.atualizar(pItem);

        // Verificando se houve erro de atualiza��o
        if (tItem == null)
            return new ItemDTO(false, "Item n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new ItemDTO(true, "Item regravado com sucesso", tItem);
    }

    // M�todo para deletar
    public static ItemDTO remover(int pIdCategoria)
    {
        // Removendo e verificando se houve erro de remo��o
    	IItem tDao = DaoFactory.getItemHibernate();
        if (! tDao.deletar(pIdCategoria))
            return new ItemDTO(false, "Item n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new ItemDTO(true, "Item removido com sucesso");
    }

    // M�todo para pesquisar 
    public static ItemDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	IItem tDao = DaoFactory.getItemHibernate();
        List<Item> tLista = tDao.pesquisar();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new ItemDTO(false, "Lista vazia");

        // Retornando a lista obtida
        return new ItemDTO(true, "Lista de Categorias recuperada", tLista);
    }

}
