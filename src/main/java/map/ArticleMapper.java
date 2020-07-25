package map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface ArticleMapper {
    @Mapping(source = "content", target = "inhalt")
    ArticleDTO fromArticle(Article article);
    @Mapping(source = "inhalt", target = "content")
    Article fromDto(ArticleDTO articleDTO);

    @Mapping(source = "inhalt", target = "content")
    Article updateFromDto(ArticleDTO articleDTO, @MappingTarget Article article);
}
