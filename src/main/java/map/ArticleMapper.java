package map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ArticleMapper {
    @Mapping(source = "content", target = "inhalt")
    ArticleDTO fromArticle(Article article);
    @Mapping(source = "inhalt", target = "content")
    Article fromDto(ArticleDTO articleDTO);
}
