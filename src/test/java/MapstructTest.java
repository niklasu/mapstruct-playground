import map.Article;
import map.ArticleDTO;
import map.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapstructTest {
    @Test
    void simpletest() {
        ArticleMapper mapper = Mappers.getMapper(ArticleMapper.class);
        String name = "bernd";
        Article article = new Article();
        article.setAuthor(name);

        ArticleDTO generatedDto = mapper.fromArticle(article);
        assertEquals(name, generatedDto.getAuthor());

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setAuthor(name);

        Article generatedArticle = mapper.fromDto(articleDTO);
        assertEquals(name, generatedArticle.getAuthor());
    }

    @Test
    void testMappingToDifferentFieldName() {
        ArticleMapper mapper = Mappers.getMapper(ArticleMapper.class);
        String content = "x";
        Article article = new Article();
        article.setContent(content);

        ArticleDTO generatedDto = mapper.fromArticle(article);
        assertEquals(content, generatedDto.getInhalt());

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setInhalt(content);

        Article generatedArticle = mapper.fromDto(articleDTO);
        assertEquals(content, generatedArticle.getContent());
    }

    @Test
    void mappingTarget() {
        ArticleMapper mapper = Mappers.getMapper(ArticleMapper.class);
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setInhalt("x");
        articleDTO.setAuthor("bernd");

        Article article = new Article();
        article.setAuthor("fred");
        article.setContent("previousConent");

        Article updatedArticle = mapper.updateFromDto(articleDTO, article);
        assertEquals(articleDTO.getAuthor(), updatedArticle.getAuthor());
        assertEquals(articleDTO.getInhalt(), updatedArticle.getContent());
    }
}
