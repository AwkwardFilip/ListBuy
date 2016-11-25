/**
 * 
 */
package ca.tds.op.controller;

import java.util.List;

import ca.tds.op.dao.DaoFactory;
import ca.tds.op.dto.LojaDTO;
import ca.tds.op.interfac.ILoja;
import ca.tds.op.model.Loja;

/**
 * @author Thanatos
 *
 */
public class LojaController 
{

	// M�todo para criar
    public static LojaDTO cadastrar(Loja pLoja)
    {
        if (pLoja == null)
            return new LojaDTO(false, "Tentativa de inserir uma Loja nulo");

        // Chamando a camada de persist�ncia
        ILoja tDao = DaoFactory.getLojaHibernate();
        Loja tLoja = tDao.criar(pLoja);

        // Verificando se houve erro de cria��o
        if (tLoja == null)
            return new LojaDTO(false, "Problemas na grava��o da Loja");

        // Retornando o indicativo de sucesso com o objeto criado
        return new LojaDTO(true, "Loja gravado com sucesso", tLoja);
    }

    // M�todo para recuperar
    public static LojaDTO recuperar(int pIdListaCompra)
    {
        // Lendo o objeto
    	ILoja tDao = DaoFactory.getLojaHibernate();
        Loja tLoja = tDao.recuperar(pIdListaCompra);

        // Verificando se houve erro de recupera��o
        if (tLoja == null)
            return new LojaDTO(false, "Loja n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new LojaDTO(true, "Loja lido com sucesso", tLoja);
    }

    // M�todo para atualizar
    public static LojaDTO atualizar(Loja pLoja)
    {
        if (pLoja == null)
            return new LojaDTO(false, "Tentativa de atualizar com um objeto nulo");

        // Chamando a camada de persist�ncia
        ILoja tDao = DaoFactory.getLojaHibernate();
        Loja tLoja = tDao.atualizar(pLoja);

        // Verificando se houve erro de atualiza��o
        if (tLoja == null)
            return new LojaDTO(false, "Loja n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new LojaDTO(true, "Loja regravado com sucesso", tLoja);
    }

    // M�todo para deletar
    public static LojaDTO remover(int pIdListaCompra)
    {
        // Removendo e verificando se houve erro de remo��o
    	ILoja tDao = DaoFactory.getLojaHibernate();
        if (! tDao.deletar(pIdListaCompra))
            return new LojaDTO(false, "Loja n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new LojaDTO(true, "Loja removido com sucesso");
    }

    // M�todo para pesquisar 
    public static LojaDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	ILoja tDao = DaoFactory.getLojaHibernate();
        List<Loja> tLista = tDao.pesquisar();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new LojaDTO(false, "Lista vazia");

        // Retornando a lista obtida
        return new LojaDTO(true, "Lista de Categorias recuperada", tLista);
    }
    

}
