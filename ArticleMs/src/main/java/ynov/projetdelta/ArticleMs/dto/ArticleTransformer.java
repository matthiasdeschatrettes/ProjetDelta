package ynov.projetdelta.ArticleMs.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ynov.projetdelta.ArticleMs.model.Article;
import ynov.projetdelta.ArticleMs.model.Cate;
import ynov.projetdelta.ArticleMs.model.Com;
import ynov.projetdelta.ArticleMs.model.User;
import ynov.projetdelta.ArticleMs.repositories.CateProxy;
import ynov.projetdelta.ArticleMs.repositories.ComProxy;
import ynov.projetdelta.ArticleMs.repositories.UserProxy;

@Component
public class ArticleTransformer {
	
	@Autowired
	private UserProxy userProxy;
	
	@Autowired
	private ComProxy comProxy;
	
	@Autowired
	private CateProxy cateProxy;
	
	public ArtR transform(Article a) {
		
		ArtR artR = new ArtR();
		artR.setId(a.getId());
		artR.setDate(a.getDate());
		artR.setContenu(a.getContenu());
		User user = userProxy.getUser(a.getIduser());
		artR.setUser(user);
		Com com = comProxy.getCom(a.getIdcom());
		artR.setCom(com);
		Cate cate = cateProxy.getCate(a.getIdcate());
		artR.setCate(cate);
		
		return artR;
	}
}
