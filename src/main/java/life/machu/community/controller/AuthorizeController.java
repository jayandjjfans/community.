package life.machu.community.controller;


import life.machu.community.dto.AccessTokenDTO;
import life.machu.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state)
    {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("2eaf9ce6d05edbfad095");
        accessTokenDTO.setClient_secret("a8b19eb2dfc02fbe448e4a1d276b9cc418361efd");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";}
}
