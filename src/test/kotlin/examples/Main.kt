package com.github.pambrose

import com.github.pambrose.Presentation.Companion.present
import kotlinx.css.Color
import kotlinx.css.color
import kotlinx.html.*

fun main() {
    presentation(title = "markdown Demo", theme = Theme.Moon) {
        css =
            """
			.slides section h3 {
				color: green;
			}
			.slides section h4 a {
				color: red;
			}
            """

        css {
            rule(".slides section h3") {
                color = Color.green
            }
        }

        markdownSlide {
            +"""
                # Markdown Example
                ```kotlin [1|3-4|2,4-5]
                ${includeFile("src/test/kotlin/examples/Test.kt")}
                ```
             """
        }

        markdownSlide {
            +"""
                # Markdown Example
                ```kotlin [1|3-4|20,24-25]
                ${includeFile(path = "src/main/kotlin/Simple.kt")}
                ```
             """.trimIndent()
        }

        htmlSlide("home") {
            h3 { +"Examples" }
            h4 { a { href = "/demo.html"; +"Demo Deck" } }
        }

        htmlSlide(transition = Transition.Zoom, speed = Speed.Slow, backgroundColor = "#bb00bb") {
            img { src = "https://picsum.photos/512/512" }
        }

        verticalSlides {
            htmlSlide(backgroundColor = "aquamarine") {
                h2 { +"🐟" }
            }

            htmlSlide(transition = Transition.Concave, speed = Speed.Slow, backgroundColor = "rgb(70, 70, 255)") {
                h2 { +"🐳" }
            }

            markdownSlide {
                +"""
                # Markdown Slide
                """.trimIndent()
            }

            markdownSlide(backgroundColor = "red") {
                +"""
                ## Demo 1
                Slide 1
                
                ---

                ## Demo 1
                Slide 2
                
                ---
                
                ## Demo 1
                Slide 3
                """
            }

            markdownSlide(filename = "public/markdown2.md")
        }

        htmlSlide("embed-web-content") {
            h2 { +"Embed Web Content" }

            iframe {
                attributes["data-autoplay"] = "true"
                attributes["frameborder"] = "0"
                width = "700"
                height = "540"
                src = "https://slides.com/news/auto-animate/embed"
            }
        }

        markdownSlide(filename = "/public/markdown.md", separator = "^---", vertical_separator = "^--")

        // Slides are separated by three dashes
        markdownSlide(separator = "---") {
            +"""
            ## Demo 1
            Slide 1
            ---
            ## Demo 1
            Slide 2
            ---
            ## Demo 1
            Slide 3
            """
        }

        // Slides are separated by newline + three dashes + newline, vertical slides identical but two dashes
        markdownSlide(separator = "\r?\\n---\r?\\n", vertical_separator = "\r?\\n--\r?\\n") {
            +"""
            ## Demo 2
            Slide 1.1

            --

            ## Demo 2
            Slide 1.2

            ---

            ## Demo 2
            Slide 2
            """
        }

        markdownSlide {
            +"""
            A

            ---

            B

            ---

            C
            """
        }

        // Slide attributes
        markdownSlide(backgroundColor = "#FFFF00") {
            +"""
                ## Slide attributes
             """
        }

        markdownSlide {
            +"""
                ## Element attributes
                - Item 1 ${fragmentIndex(1)}
                - Item 2 ${fragmentIndex(2)}
                - Item 3 ${fragmentIndex(2)}
                """
        }

        markdownSlide(id = "markdown-example") {
            +"""
                # Markdown Example
                ```kotlin [1|3-4]
                    fun main() {
                        println("Hello")
                        println("World")
                    }
                ```
                """
        }

        htmlSlide {
            section {
                +"Slide 2"
            }
            section {
                +"Sub 1"
            }
            section {
                +"Sub 2"
            }
        }

        htmlSlide {
            +"Slide 3"
            h4 { a { href = "#/home"; +"Home" } }
        }

        htmlSlide(backgroundIframe = "https://revealjs.com") {
            //attributes["data-background-interactive"] = "false"
            div {
                style =
                    "position: absolute; width: 40%; right: 0; box-shadow: 0 1px 4px rgba(0,0,0,0.5), 0 5px 25px rgba(0,0,0,0.2); background-color: rgba(0, 0, 0, 0.9); color: #fff; padding: 20px; font-size: 20px; text-align: left;"
                h2 { +"Iframe Backgrounds" }
                p {
                    +"""Since reveal.js runs on the web, you can easily embed other web content. Try interacting with the
                    page in the background."""
                }
            }
        }

        // Images
        markdownSlide {
            +"![Sample image](https://picsum.photos/512/512)"
        }
    }

    presentation("/demo.html") {
        htmlSlide {
            +"Demo Slide 1"
        }

        htmlSlide {
            +"Demo Slide 2"
        }
    }

    present()
}